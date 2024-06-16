import java.util.HashMap;

public class KDifferencePairs {

    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;  // Absolute difference cannot be negative

        HashMap<Integer, Integer> numCount = new HashMap<>();
        int count = 0;

        // Count the frequency of each number
        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        for (int num : numCount.keySet()) {
            if (k == 0) {
                // If k is 0, we need at least two occurrences of the same number
                if (numCount.get(num) > 1) {
                    count++;
                }
            } else {
                // Otherwise, check if the pair exists
                if (numCount.containsKey(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        System.out.println(findPairs(nums, k));  // Output: 2
    }
}
