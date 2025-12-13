// Category: algorithms
// Level: Medium
// Percent: 64.73743%



// Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
// 
// Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
// 
// The test cases are generated so that there will be an answer.
// 
//  
// Example 1:
// 
// Input: nums = [1,2,5,9], threshold = 6
// Output: 5
// Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
// If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 
// 
// 
// Example 2:
// 
// Input: nums = [44,22,33,11,1], threshold = 5
// Output: 44
// 
// 
//  
// Constraints:
// 
// 
// 	1 <= nums.length <= 5 * 10⁴
// 	1 <= nums[i] <= 10⁶
// 	nums.length <= threshold <= 10⁶
// 
 

class Solution {
    private int getSum(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num: nums) {
            sum += (num + divisor - 1) / divisor;

            if (sum > threshold) {
                return -1;
            }
        }

        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int divisor = 1;
        while (getSum(nums, divisor, threshold) == -1) {
            divisor *= 2;
        }

        if (divisor == 1) {
            return divisor;
        }

        int end = divisor;
        int start = divisor / 2;
        while (true) {
            int mid = start + (end - start) / 2;

            if (start == end) {
                return end;
            }

            int midsum = getSum(nums, mid, threshold);
            if ((end - start) <= 1) {
                return midsum == -1 ? end : mid;
            }

            if (midsum == -1) {
                start = mid;
            } else {
                end = mid;
            }

        }
    }
}
