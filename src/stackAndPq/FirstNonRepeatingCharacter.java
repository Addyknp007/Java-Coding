package stackAndPq;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static String findFirstNonRepeating(String stream) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        StringBuilder result = new StringBuilder();

        for (char c : stream.toCharArray()) {
            // Update frequency map
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);

            // Add the character to the queue
            queue.offer(c);

            // Remove characters from the queue until the first non-repeating character is found
            while (!queue.isEmpty() && frequencyMap.get(queue.peek()) > 1) {
                queue.poll();
            }

            // Append the result, either the first non-repeating character or '#' if none found
            if (queue.isEmpty()) {
                result.append('#');
            } else {
                result.append(queue.peek());
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String stream = "aabbcddeeff";
        String result = findFirstNonRepeating(stream);
        System.out.println(result); // Output: "aaaaaaaabb"
    }
}
