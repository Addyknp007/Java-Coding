package stackAndPq;

import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {
    public static int maxRectangleArea(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Update the heights array based on the current row
                if (matrix[row][col] == 0) {
                    heights[col] = 0;
                } else {
                    heights[col] += 1;
                }
            }

            // Calculate the maximum area histogram for the current row
            int area = maxAreaHistogram(heights);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int maxAreaHistogram(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        int maxArea = maxRectangleArea(matrix);
        System.out.println("Maximum Area Rectangle in Binary Matrix: " + maxArea);
    }
}
