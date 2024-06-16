import java.util.HashMap;

public class LongestSubarrayWithKDistinct {

    public static int longestSubarrayWithKDistinct(int[] nums, int k) {
        if (k == 0) return 0;

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < nums.length) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while (freqMap.size() > k) {
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
            if (freqMap.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(longestSubarrayWithKDistinct(nums, k));  // Output: 4
    }
}
