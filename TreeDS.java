package com.ShuvroBarua;
import java.util.*;

public class TreeDS {
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	// Creating a tree:
	// It returns the root after creating the tree.
	static class BinaryDS {
		static int index = -1;
		static Node buildTree(int[] nums) {
			index++;
			if(nums[index] == -1) {
				return null;
			}
			Node newNode = new Node(nums[index]);
			newNode.left = buildTree(nums);
			newNode.right = buildTree(nums);
			return newNode;
		}	
	}
	
	//preOrder Traversal: Root -> Left -> Right
	public static void preOrder(Node root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	//InOrder Traversal: Left -> Root -> Right
	public static void inOrder(Node root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	//PostOrder Traversal: Left -> Right -> Root.
	public static void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	
	//LevelOrder Traversal: Prints level by level.
	public static void levelOrder(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node currNode = q.remove();
			if(currNode == null) {
				System.out.println();
				if(q.isEmpty()) {
					break;
				}
				else {
					q.add(null);
				}
			}
			else {
				System.out.print(currNode.data+ " ");
				if(currNode.left != null) {
					q.add(currNode.left);
				}
				if(currNode.right != null) {
					q.add(currNode.right);
				}
			}
		}
	}
	public static int countOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		int leftNodes = countOfNodes(root.left);
		int rightNodes = countOfNodes(root.right);
		
		return (leftNodes + rightNodes + 1);
	}
	
	public static int sumOfNodes(Node root) {
		if(root == null) {
			return 0;
		}

		return sumOfNodes(root.left)+ sumOfNodes(root.right) + root.data;
	}
	
	public static int heightOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		
		int leftHeight = heightOfTree(root.left);
		int rightHeight = heightOfTree(root.right);
		int myHeight = Math.max(leftHeight, rightHeight) + 1;
		
		return myHeight;
	}
	
	//Returns the diameter but the complexity is quadratic.
	public static int diameterOfTree(Node root) {
		if(root == null) {
			return 0;
		}
		int leftDiam = diameterOfTree(root.left);
		int rightDiam = diameterOfTree(root.right);
		int rootDiam = TreeDS.heightOfTree(root.left) + TreeDS.heightOfTree(root.right) + 1;
		
		return Math.max(rootDiam, Math.max(leftDiam, rightDiam));
	}
	
	public static class TreeHD{
		int height; 
		int diameter;
		
		TreeHD(int height, int diameter){
			this.height = height;
			this.diameter = diameter;
		}
	}
	
	public static TreeHD diameter2(Node root) {
		if(root == null) {
			return new TreeHD(0,0);
		}
		
		TreeHD left = diameter2(root.left);
		TreeHD right = diameter2(root.right);
		
		int myHeight = Math.max(left.height, right.height) + 1;
		
		int diam1 = left.diameter;
		int diam2 = right.diameter;
		int diam3 = left.height + right.height + 1;
		
		int myDiam = Math.max(Math.max(diam1, diam2), diam3);
		
		TreeHD myTree = new TreeHD(myHeight, myDiam);
		return myTree;
	}
	
	public static boolean isIdentical(Node root, Node subRoot) {
		if(root == null && subRoot == null) {
			return true;
		}
		if(root == null || subRoot == null) {
			return false;
		}
		if(root.data == subRoot.data) {
			return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
		}
		
		return false;
	}
	
	public static boolean isSubtree(Node root, Node subRoot) {
		if(subRoot == null) {
			return true;
		}
		if(root == null) {
			return false;
		}
		if(root.data == subRoot.data) {
			if(isIdentical(root, subRoot)) {
				return true;
			}
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot); 
	}
	
	//To determine whether any element is exist in the tree or not.
	public static boolean isExists(Node root, int data) {
		if(root == null) {
			return false;
		}
		if(root.data == data) {
			return true;
		}
		
		return isExists(root.left, data) || isExists(root.right, data);
	}
	
	//For inserting an element in a binary tree.
	public static void insert(Node root, int data) {
		if(root == null) {
			root = new Node(data);
		}
		else {
			insertHelper(root, data);
		}
		
	}
	
	public static void insertHelper(Node root, int data) {
		if(root.data >= data) {
			if(root.left == null) {
				root.left = new Node(data);
			}
			else {
				insertHelper(root.left, data);
			}
		}
		else {
			if(root.right == null) {
				root.right = new Node(data);
			}
			else {
				insertHelper(root.right, data);
			}
		}
	}
}
