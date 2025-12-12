// Category: algorithms
// Level: Hard
// Percent: 53.166546%



// Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
// 
// You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
// 
// Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
// 
// Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
// 
// The answer is guaranteed to fit in a 32-bit signed integer.
// 
//  
// Example 1:
// 
// Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
// Output: 4
// Explanation: Since your initial capital is 0, you can only start the project indexed 0.
// After finishing it you will obtain profit 1 and your capital becomes 1.
// With capital 1, you can either start the project indexed 1 or the project indexed 2.
// Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
// Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
// 
// 
// Example 2:
// 
// Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
// Output: 6
// 
// 
//  
// Constraints:
// 
// 
// 	1 <= k <= 10⁵
// 	0 <= w <= 10⁹
// 	n == profits.length
// 	n == capital.length
// 	1 <= n <= 10⁵
// 	0 <= profits[i] <= 10⁴
// 	0 <= capital[i] <= 10⁹
// 
 
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static class Node {
        int capital;
        int profit;

        public Node(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Node> nodes = new ArrayList<>(capital.length);

        for (int i = 0; i < capital.length; i++) {
            nodes.add(new Node(capital[i], profits[i]));
        }

        PriorityQueue<Node> minheap = new PriorityQueue<>((a, b) -> Integer.compare(a.capital, b.capital));
        minheap.addAll(nodes);


        PriorityQueue<Node> maxheap = new PriorityQueue<>((a, b) -> -1 * Integer.compare(a.profit, b.profit));

        int currentcap = w;

        for (int numprojects = k; numprojects > 0; numprojects--) {

            while (!minheap.isEmpty() && minheap.peek().capital <= currentcap) {
                maxheap.add(minheap.poll());
            }

            currentcap += maxheap.poll().profit;
        }

        return currentcap - w;
    }
}
