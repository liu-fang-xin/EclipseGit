package com.atguigu.tree.redblack;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

public class RedBlackTree<Key extends Comparable<Key>,Value> {
	//���ڵ�
	public Node root;
	//��¼����Ԫ�صĸ���
	public int N;
	//��ɫ����
	private static final boolean RED = true;
	//��ɫ����
	private static final boolean BLACK = false;
	
	//�����
	private class Node{
		//�洢��
		public Key key;
		//�洢ֵ
		private Value value;
		//��¼���ӽ��
		public Node left;
		//��¼���ӽ��
		public Node right;
		//���丸���ָ������������ɫ
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
	
	//��ȡ����Ԫ�صĸ���
	public int size() {
		return N;
	}
	/**
	 * �жϵ�ǰ���ĸ�ָ�����Ƿ�Ϊ��ɫ
	*/
	private boolean isRed(Node x) {
		if(x==null) {
		 return false;
		}
		return x.color==RED;
	}
	
	/**
	 * ����ת
	 * */
	private Node rotateLeft(Node h) {
		//��ȡ�������ӽ�㣬��ʾΪX��
		Node x =h.right;
		//��x�������ӽ���Ϊh�������ӽ��
		h.right=x.left;
		//��h��Ϊx�����ӽ��
		x.left=h;
		//��x����color���Ե���h����color
		x.color=h.color;
		//��h����color����  ��ɫ
		h.color=RED;
		return x;
	}
	/**
	 * ����ת
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
	 * ��ɫ��ת
	 */
	private void flipColors(Node h) {
		h.color=RED;
		
		h.left.color=BLACK;
		h.right.color=BLACK;
	}
	//������������ɲ������
	public void put (Key key,Value value) {
		root=put(root,key,value);
		//��������ɫ���Ǻ�ɫ��
		root.color = BLACK;
	}
	//��ָ����������ɲ������
	public Node put(Node h,Key key,Value value) {
		if(h==null) {
			//������1
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
		//������������ǰ���h�����ӽ��Ϊ��ɫ�����ӽ��Ϊ��ɫ����Ҫ����
		if(isRed(h.right)&& !isRed(h.left)) {
			h=rotateLeft(h);
		}
		//��������
		if (isRed(h.left)&&isRed(h.left.left)) {
			h=rotateRight(h);
		}
		//��ɫ��ת
		if(isRed(h.left)&&isRed(h.right)) {
			flipColors(h);
		}
		return h;
	}
	//�����ϻ�ȡkey��Ӧ��ֵ
	public Value get (Key key) {
		return get(root,key);
	}
	//��ָ�������ϻ�ȡ��Ӧ��ֵ
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
