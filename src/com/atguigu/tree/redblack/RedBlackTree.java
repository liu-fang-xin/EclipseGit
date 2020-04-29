package com.atguigu.tree.redblack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
	//根节点
	public Node root;
	//记录树中元素的个数
	public int N;
	//红色链接
	private static final boolean RED = true;
	//黑色链接
	private static final boolean BLACK = false;
	
	//结点类
	private class Node{
		//存储键
		public Key key;
		//存储值
		private Value value;
		//记录左子结点
		public Node left;
		//记录右子结点
		public Node right;
		//由其父结点指向它的链接颜色
		public boolean color;
		public Node(Key key, Value value, RedBlackTree<Key, Value>.Node left, RedBlackTree<Key, Value>.Node right,
				boolean color) {
			super();
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
			this.color = color;
		}
		
	
	}
	
	//获取树中元素的个数
	public int size() {
		return N;
	}
	/**
	 * 判断当前结点的父指向结点是否为红色
	*/
	private boolean isRed(Node x) {
		if(x==null) {
		 return false;
		}
		return x.color==RED;
	}
	
	/**
	 * 左旋转
	 * */
	private Node rotateLeft(Node h) {
		//获取结点的右子结点，表示为X；
		Node x =h.right;
		//让x结点的左子结点称为h结点的右子结点
		h.right=x.left;
		//让h称为x的左子结点
		x.left=h;
		//让x结点的color属性等于h结点的color
		x.color=h.color;
		//让h结点的color等于  红色
		h.color=RED;
		return x;
	}
	/**
	 * 右旋转
	 * */
	private Node rotateRight(Node h) {
		
		Node x =h.left;
		
		h.left=x.right;
		
		x.right=h;
		
		x.color=h.color;
		
		h.color=RED;
		return x;
	}
	/**
	 * 颜色反转
	 */
	private void flipColors(Node h) {
		h.color=RED;
		
		h.left.color=BLACK;
		h.right.color=BLACK;
	}
	//在整棵树上完成插入操作
	public void put (Key key,Value value) {
		root=put(root,key,value);
		//根结点的颜色总是黑色的
		root.color = BLACK;
	}
	//在指定的树上完成插入操作
	public Node put(Node h,Key key,Value value) {
		if(h==null) {
			//数量加1
			N++;
			return new Node(key, value, null, null, RED);
		}
		
		int cmp=key.compareTo(h.key);
		if(cmp<0) {
			h.left=put(h.left, key, value);
		}
		if(cmp>0) {
			h.right=put(h.right, key, value);
		}
		else {
			h.value=value;
		}
		//进行左旋，当前结点h的左子结点为黑色，右子结点为红色，需要左旋
		if(isRed(h.right)&& !isRed(h.left)) {
			h=rotateLeft(h);
		}
		//进行右旋
		if (isRed(h.left)&&isRed(h.left.left)) {
			h=rotateRight(h);
		}
		//颜色反转
		if(isRed(h.left)&&isRed(h.right)) {
			flipColors(h);
		}
		return h;
	}
	//从树上获取key对应的值
	public Value get (Key key) {
		return get(root,key);
	}
	//从指定的树上获取对应的值
	public Value get(Node x,Key key) {
		if (x==null) {
			return null;
		}
		
		int cmp=key.compareTo(x.key);
		if(cmp<0) {
			return get(x.left,key);
		}
		if(cmp>0) {
			return get(x.right,key);
		}
		else {
			return x.value;
		}
	
	}
	
}
