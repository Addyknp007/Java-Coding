public class NumWaysSolution {
    public int numWays(int steps, int arrLen) {
        if (steps == 0 || arrLen == 1) {
            return 1;
        }

        int MOD = (int) (Math.pow(10, 9) + 7);
        return helper(0, steps, arrLen, MOD);
    }

    private int helper(int pos, int steps, int n, int MOD) {
        if (steps == 0) {
            return (pos == 0) ? 1 : 0;
        }

        if (pos < 0 || pos >= n) {
            return 0;
        }

        int res = helper(pos, steps - 1, n, MOD);
        if (0 <= pos + 1 && pos + 1 < n) {
            res = (res + helper(pos + 1, steps - 1, n, MOD)) % MOD;
        }
        if (0 <= pos - 1 && pos - 1 < n) {
            res = (res + helper(pos - 1, steps - 1, n, MOD)) % MOD;
        }

        return res;
    }

    public static void main(String[] args) {
        NumWaysSolution solution = new NumWaysSolution();
        int steps = 3;
        int arrLen = 2;
        int ways = solution.numWays(steps, arrLen);
        System.out.println("Number of ways to stay in place: " + ways);
    }
}
