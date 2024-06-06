package org.example.leetcode;

import java.util.ArrayDeque;

class Solution {
    public static void main(String[] args) {
        new Solution().maxSlidingWindow(new int[]{1,2,3,4,5,6,1,2,3,4,1,2,3} , 3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // maintain monotonic decreasing.
            // all elements in the deque smaller than the current one
            // have no chance of being the maximum, so get rid of them
            while (!queue.isEmpty() && nums[i] > nums[queue.getLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);

            // queue[0] is the index of the maximum element.
            // if queue[0] + k == i, then it is outside the window
            if (queue.getFirst() + k == i) {
                queue.removeFirst();
            }

            // only add to the answer once our window has reached size k
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }

        return ans;
    }
}