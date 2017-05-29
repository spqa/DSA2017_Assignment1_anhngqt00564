package org.datastructure.tree;

public class TreeNode<E extends Comparable<E>> {

	//hold reference to object
	E data;
	//each node of a binary tree have most 2 children
	TreeNode<E> leftChild;
	TreeNode<E> rightChild;	
}
