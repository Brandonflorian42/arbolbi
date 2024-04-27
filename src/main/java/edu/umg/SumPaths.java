package edu.umg;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SumPaths {
    public List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, paths);
        return paths;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        currentPath.add(node.val);
        targetSum -= node.val;

        if (node.left == null && node.right == null && targetSum == 0) {
            paths.add(new ArrayList<>(currentPath));
        }

        dfs(node.left, targetSum, currentPath, paths);
        dfs(node.right, targetSum, currentPath, paths);
        currentPath.remove(currentPath.size() - 1);
    }
}
