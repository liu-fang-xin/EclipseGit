package com.atguigu.tree.redblack;

public class TestRedBlack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackTree<Integer, String> tree=new RedBlackTree<>();
		
		tree.put(1, "zhangsan");
		tree.put(2,"lisi");
		tree.put(3, "wangwu");
		tree.put(3, "wangwu");
		tree.put(3, "wangwu");
		tree.put(3, "wangwu");
		tree.put(3, "wangwu");
		tree.put(3, "wangwu");
		
		
		System.out.println(tree.get(3));
		
	}

}
