class Solution {
    public HashMap<Integer, Integer> maxOfRow;

    public List<Integer> largestValues(TreeNode root) {
        maxOfRow = new HashMap<>();

        find(root, 1);

        return maxOfRow.values().stream().toList();
    }

    public void find(TreeNode node, int row){
        if(node == null){
            return;
        }
        int max = maxOfRow.getOrDefault(row, Integer.MIN_VALUE);
        if(max <= node.val){
            maxOfRow.put(row, node.val);
        }

        find(node.left, row+1);
        find(node.right, row+1);
    }
}
