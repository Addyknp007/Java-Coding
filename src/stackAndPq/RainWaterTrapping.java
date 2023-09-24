package stackAndPq;

import java.util.Stack;

public class RainWaterTrapping {
    public static int trapRainWater(int[] heights) {
        int n = heights.length;
        if (n <= 2) {
            return 0; // Not enough bars to trap water
        }

        int trappedWater = 0;
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < n; current++) {
            while (!stack.isEmpty() && heights[current] > heights[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break; // No left boundary to trap water
                }

                int distance = current - stack.peek() - 1;
                int boundedHeight = Math.min(heights[current], heights[stack.peek()]) - heights[top];
                trappedWater += distance * boundedHeight;
            }
            stack.push(current);
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trappedWater = trapRainWater(heights);
        System.out.println("Trapped Rainwater: " + trappedWater + " units");
    }
}

