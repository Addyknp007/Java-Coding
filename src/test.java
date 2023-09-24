public class test {
// HashMap<String,Long> map = new HashMap();

    public int numWays(int steps, int arrLen) {

        int MOD = 1_000_000_007;

        return helper(steps, arrLen,0, MOD);
    }

    private int helper(int moves , int N , int i,int MOD) {
        // Base case 2: If we have taken 0 steps or are out of bounds, there is 0 way.
        if ( i >= moves ||i < 0 ) {
            return 0;
        }
        // Base case 1: If we have taken 0 steps and are at position 0, there is 1 way.
        if (moves  == 0 && N  == 0) {
            return 1;
        }
        int ways = helper(moves  - 1,N , i ,MOD);
        if(0 <= i - 1 && i - 1 < N){
            ways = (ways + helper(moves  - 1,N , i - 1, MOD)) % MOD;
        }
        if(0 <= i + 1 && i + 1 < N){
            ways = (ways + helper(moves  - 1,N  ,i + 1, MOD)) % MOD;

        }
        return ways;
    }

    public static void main(String[] args) {
        NumWaysSolution solution = new NumWaysSolution();
        int steps = 4;
        int arrLen = 2;
        int ways = solution.numWays(steps, arrLen);
        System.out.println("poa   Number of ways to stay in place: " + ways);
    }
}
