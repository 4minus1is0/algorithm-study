/**
 날짜: 2026/07/22
 시간: 30분
 풀이 여부: X
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private List<List<Integer>> binary = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int nextTargetSum = targetSum - root.val;

        return hasPathSum(root.left, nextTargetSum) ||
                hasPathSum(root.right, nextTargetSum);
    }

}
