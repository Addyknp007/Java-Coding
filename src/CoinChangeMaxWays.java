public class CoinChangeMaxWays {
    public static int maxWays(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        // Initialize the first column to 1 (there is one way to make amount 0 with any coin)
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int ways = maxWays(coins, amount);
        System.out.println("Maximum number of ways to make " + amount + " using coins: " + ways);
    }
}
