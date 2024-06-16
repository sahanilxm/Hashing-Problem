
#include<bits/stdc++.h>
using namespace std;

int findPairs(vector<int>& nums, int k) {
    if (k < 0) return 0;  // Absolute difference cannot be negative

    unordered_map<int, int> num_count;
    int count = 0;

    // Count the frequency of each number
    for (int num : nums) {
        num_count[num]++;
    }

    for (auto& [num, freq] : num_count) {
        if (k == 0) {
            // If k is 0, we need at least two occurrences of the same number
            if (freq > 1) {
                count++;
            }
        } else {
            // Otherwise, check if the pair exists
            if (num_count.find(num + k) != num_count.end()) {
                count++;
            }
        }
    }

    return count;
}

int main() {
    vector<int> nums = {3, 1, 4, 1, 5};
    int k = 2;
    cout << findPairs(nums, k) << endl;  // Output: 2
    return 0;
}
