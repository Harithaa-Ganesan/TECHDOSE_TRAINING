You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 
SOLUTION:

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // arr = {val, index}
        // Max heap
        Queue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for(int i = 0; i < k; i++) {
            q.add(new int[]{nums[i], i});
        }
        
        
        int cur = k;
        int index = 1;
        int[] ans = new int[nums.length - k + 1];
        ans[0] = q.peek()[0];
        
        while(cur < nums.length) {
            
            
            // remove out of window elements
            while(!q.isEmpty() && (q.peek()[1] < cur - k + 1)) {
                q.remove();
            }
            
            q.add(new int[]{nums[cur], cur});
            ans[index++] = q.peek()[0];
            cur++;
        }
        
        return ans;
        
        
    }
}
