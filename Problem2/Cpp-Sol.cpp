#include<bits/stdc++.h>
using namespace std;

int longestSubarrayWithKDistinct(vector<int>& nums, int k) {
    if (k == 0) return 0;

    unordered_map<int, int> freqMap;
    int left = 0, right = 0, maxLength = 0;

    while (right < nums.size()) {
        freqMap[nums[right]]++;
        while (freqMap.size() > k) {
            freqMap[nums[left]]--;
            if (freqMap[nums[left]] == 0) {
                freqMap.erase(nums[left]);
            }
            left++;
        }
        if (freqMap.size() == k) {
            maxLength = max(maxLength, right - left + 1);
        }
        right++;
    }

    return maxLength;
}

int main() {
    vector<int> nums = {1, 2, 1, 2, 3};
    int k = 2;
    cout << longestSubarrayWithKDistinct(nums, k) << endl;  // Output: 4
    return 0;
}
