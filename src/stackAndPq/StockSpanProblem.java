package stackAndPq;

import java.util.*;

public class StockSpanProblem {
    public static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();

        // The first day always has a span of 1
        spans[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // Pop elements from the stack while the current price is greater than the price at the top
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }

            // Calculate the span for the current day
            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push the current day onto the stack
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] stockPrices = { 80, 60, 70, 60, 75, 85};
        int[] spans = calculateStockSpan(stockPrices);

        System.out.println("Stock Prices: " + Arrays.toString(stockPrices));
        System.out.println("Stock Spans  : " + Arrays.toString(spans));
    }
}

