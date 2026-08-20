class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        find(root, 0, result);
        return result;
    }

    private void find(
            TreeNode node,
            int depth,
            List<List<Integer>> result
    ) {
        if (node == null) {
            return;
        }

        if (result.size() == depth) {
            result.add(new ArrayList<>());
        }

        result.get(depth).add(node.val);

        find(node.left, depth + 1, result);
        find(node.right, depth + 1, result);
    }
}
