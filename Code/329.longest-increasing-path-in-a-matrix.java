// Category: algorithms
// Level: Hard
// Percent: 55.833115%



// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
// 
// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
// 
//  
// Example 1:
// 
// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].
// 
// 
// Example 2:
// 
// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
// 
// 
// Example 3:
// 
// Input: matrix = [[1]]
// Output: 1
// 
// 
//  
// Constraints:
// 
// 
// 	m == matrix.length
// 	n == matrix[i].length
// 	1 <= m, n <= 200
// 	0 <= matrix[i][j] <= 2³¹ - 1
// 

import java.util.Objects;

class Solution {
    private class Point {
        int i;
        int j;

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return point.i == i && point.j == j;
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        
        int[][] dp = new int[matrix.length][matrix[0].length];

        int mini = 0;
        int minj = 0;
        int min = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }

        // Set min to 0
        dp[mini][minj] = 0;

        int maxPathLength = 0;

        Queue<Point> traversalQueue = new Queue<>();
        traversalQueue.add(new Point(mini, minj));

        Set<Point> visited = new HashSet<>();
        visited.add(new Point(mini, minj));

        while (!traversalQueue.isEmpty()) {
            Point nextCell = traversalQueue.poll();

            int celli = nextCell.i;
            int cellj = nextCell.j;

            if (matrix[celli][cellj] == )

        }
    }
}
