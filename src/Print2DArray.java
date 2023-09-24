public class Print2DArray {
    public static void main(String[] args) {
        int[][] twoDArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10,11,12}
        };

        // Get the number of rows and columns
        int rows = twoDArray.length;
        int cols = twoDArray[0].length;

        // Iterate through the array and print each element
        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                System.out.print(twoDArray[i][j] + " ");
//            }
            System.out.print(twoDArray[i][0] + " ");
//            System.out.println(); // Move to the next line after each row
        }
    }
}
