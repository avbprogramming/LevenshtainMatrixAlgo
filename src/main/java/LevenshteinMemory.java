
// Левенштейн с памятью
import java.time.Instant;
import java.util.Arrays;

public class LevenshteinMemory {
    // static Instant startInstant = Instant.now();

  public static int computeLevenshteinDistanceDP(String s1, String s2) {
        // A 2-D matrix to store previously calculated answers of subproblems in order to obtain the final
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // If s1 is empty, all characters of s2 are inserted into s1, which is of the only possible method of conversion with minimum operations.
                if (i == 0) {
                    dp[i][j] = j;
                }
                // If s2 is empty, all characters of s1 are removed, which is the only possible method of conversion with minimum operations.
                else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    // find the minimum among three operations below
                    dp[i][j] = minm_edits(dp[i - 1][j - 1] + NumOfReplacement(s1.charAt(i - 1), s2.charAt(j - 1)), // replace
                            dp[i - 1][j] + 1, // delete
                            dp[i][j - 1] + 1); // insert
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    // check for distinct characters in s1 and s2
    static int NumOfReplacement(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    // receives the count of different operations performed and returns the minimum value among them.
    static int minm_edits(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

  //  static Instant finishInstant = Instant.now();
 //   static long difference = finishInstant.toEpochMilli() - startInstant.toEpochMilli();
}