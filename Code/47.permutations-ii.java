// Category: algorithms
// Level: Medium
// Percent: 62.30281%



// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
// 
//  
// Example 1:
// 
// Input: nums = [1,1,2]
// Output:
// [[1,1,2],
//  [1,2,1],
//  [2,1,1]]
// 
// 
// Example 2:
// 
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
// 
//  
// Constraints:
// 
// 
// 	1 <= nums.length <= 8
// 	-10 <= nums[i] <= 10
// 
 
import java.util.*;
class Solution {
    private void permuteUnique(sequence, Set<Integer> visited, List<Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            Integer curr = nums.get(i);
            if (visited.contains(curr)) {
                continue;
            }

            nums.remove(i);
            visited.add(curr);
            
            
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

    }
}
