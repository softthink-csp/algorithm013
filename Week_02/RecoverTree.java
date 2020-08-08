package com.example.demo;

public class RecoverTree {
	
	/**
	 * 分析，二叉搜索树交换的结果是，中序遍历结果不在单调递增，
	 * 也就是被交换的第一个点不在跟紧邻的后一个节点不在单调递增。
	 * 被交换的第二个节点与紧邻的前一个节点不在单调递增。
	 * 特殊情况时交换的时相邻的两个节点。
	 * 
	 * 解题思路：方法一：先中序遍历，然后依次比较中序遍历结果相邻的值，找出非单调递增的值。空间复杂度为O(n)
	 * 方法二：中序遍历，记录中序遍历的前一个值和当前值进行比较。看是否单调递增。空间复杂度为O(1)
	 * 一个坑为，递归过程中保证传入的中序遍历前一个参数的正确性。
	 * 
	 * @param root
	 */
	public void execute(TreeNode root) {
		TreeNode[] nodeArr = new TreeNode[3];
		TreeNode left = root;
		TreeNode prev = left;
		while (left != null) {
			prev = left;
			left = left.left;
		}
		nodeArr[2] = prev;
		helper(root, nodeArr);
		int temp = nodeArr[0].val;
		nodeArr[0].val = nodeArr[1].val;
		nodeArr[1].val = temp;
	}

	public void helper(TreeNode node, TreeNode[] nodeArr) {
		if (node == null) {
			return;
		}
		helper(node.left, nodeArr);
		if (nodeArr[2].val > node.val) {
			if (nodeArr[0] == null) {
				nodeArr[0] = nodeArr[2];
				nodeArr[1] = node;
			} else {
				nodeArr[1] = node;
			}
		}
		nodeArr[2] = node;
		helper(node.right, nodeArr);
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
