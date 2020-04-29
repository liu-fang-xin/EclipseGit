package com.atguigu.stack;

import java.util.Stack;

public class LinkedListStackDemo {
		/*
		* �����οκ�С��ϰ
		 */
	public static void main(String[] args) {
		
		
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		
		LinkedListStack stack=new LinkedListStack();
		
		stack.push(hero1);
		stack.push(hero2);
		stack.push(hero3);
		stack.push(hero4);
		stack.list();
		System.out.println("--------------------------------------");
		System.out.println(stack.pop());
		System.out.println("-------------------------------------------");
		stack.list();
		System.out.println("-------------------------------------------");
		System.out.println(stack.pop());
		System.out.println("-------------------------------------------");
		
		

	}

}



//����LinkedListStack �������ǵ�Ӣ��
class LinkedListStack {
	//�ȳ�ʼ��һ��ͷ�ڵ�, ͷ�ڵ㲻Ҫ��, ����ž��������
	private HeroNode head = new HeroNode(0, "", "");
	
	
	//����ͷ�ڵ�
	public HeroNode getHead() {
		return head;
	}

	//��ӽڵ㵽��������
	//˼·���������Ǳ��˳��ʱ
	//1. �ҵ���ǰ��������ڵ�
	//2. ���������ڵ��next ָ�� �µĽڵ�
	public void push(HeroNode heroNode) {
		
		//��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
		HeroNode temp = head;
		//���������ҵ����
		while(true) {
			//�ҵ���������
			if(temp.next == null) {//
				break;
			}
			//���û���ҵ����, ����temp����
			temp = temp.next;
		}
		//���˳�whileѭ��ʱ��temp��ָ������������
		//���������ڵ��next ָ�� �µĽڵ�
		temp.next = heroNode;
	}
	
	
	public HeroNode pop() {
		//��Ϊhead�ڵ㲻�ܶ������������Ҫһ���������� temp
			HeroNode temp = head.next;
			if(temp==null) {
				throw new RuntimeException("ջΪ�գ�����pop");
			}
			if(temp.next==null) {
				return temp;
			}
			//���������ҵ�����ǰһ��
			while(true) {
				//�ҵ���������
				if(temp.next.next == null) {//
					break;
				}
				//���û���ҵ����, ����temp����
				temp = temp.next;
			}
			HeroNode popNode=temp.next;
			temp.next=null;
			return popNode;
			
	}
	
	
	
	//��ʾ����[����]
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊͷ�ڵ㣬���ܶ������������Ҫһ����������������
		HeroNode temp = head.next;
		while(true) {
			//�ж��Ƿ��������
			if(temp == null) {
				break;
			}
			//����ڵ����Ϣ
			System.out.println(temp);
			//��temp���ƣ� һ��С��
			temp = temp.next;
		}
	}
}

//����HeroNode �� ÿ��HeroNode �������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; //ָ����һ���ڵ�
	//������
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//Ϊ����ʾ��������������toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}