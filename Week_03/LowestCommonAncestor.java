package com.example.demo;

/**
 * 236. 二叉树的最近公共祖先
 * 
 * @author bing5
 *
 */
public class LowestCommonAncestor {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private LowestCommonAncestor() {

	}

	public static TreeNode execute(TreeNode root, TreeNode p, TreeNode q) {
		// 思路，递归，分别遍历左右子节点，如果找到p 或者 q 或者遍历到叶子节点则返回
		// 比较左右子节点的结果，如果两方分别为q, p则说明找到了。
		// 如果一方为p,q另一方为空，则返回非空方，直到根节点，如果都是一方为空，则说明另一个元素为非空元素的子节点
		// 返回非空节点
		if (root == null || root == p || root == q)
			return root;
		TreeNode right = execute(root.right, p, q);
		TreeNode left = execute(root.left, p, q);
		if (right == null)
			return left;
		if (left == null)
			return right;
		return root;
	}

}
