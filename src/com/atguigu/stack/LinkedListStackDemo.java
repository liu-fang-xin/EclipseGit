package com.atguigu.stack;

import java.util.Stack;

public class LinkedListStackDemo {
		/*
		* 刘方鑫课后小练习
		 */
	public static void main(String[] args) {
		
		
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		
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



//定义LinkedListStack 管理我们的英雄
class LinkedListStack {
	//先初始化一个头节点, 头节点不要动, 不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");
	
	
	//返回头节点
	public HeroNode getHead() {
		return head;
	}

	//添加节点到单向链表
	//思路，当不考虑编号顺序时
	//1. 找到当前链表的最后节点
	//2. 将最后这个节点的next 指向 新的节点
	public void push(HeroNode heroNode) {
		
		//因为head节点不能动，因此我们需要一个辅助遍历 temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true) {
			//找到链表的最后
			if(temp.next == null) {//
				break;
			}
			//如果没有找到最后, 将将temp后移
			temp = temp.next;
		}
		//当退出while循环时，temp就指向了链表的最后
		//将最后这个节点的next 指向 新的节点
		temp.next = heroNode;
	}
	
	
	public HeroNode pop() {
		//因为head节点不能动，因此我们需要一个辅助遍历 temp
			HeroNode temp = head.next;
			if(temp==null) {
				throw new RuntimeException("栈为空，不能pop");
			}
			if(temp.next==null) {
				return temp;
			}
			//遍历链表，找到最后的前一个
			while(true) {
				//找到链表的最后
				if(temp.next.next == null) {//
					break;
				}
				//如果没有找到最后, 将将temp后移
				temp = temp.next;
			}
			HeroNode popNode=temp.next;
			temp.next=null;
			return popNode;
			
	}
	
	
	
	//显示链表[遍历]
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		//因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while(true) {
			//判断是否到链表最后
			if(temp == null) {
				break;
			}
			//输出节点的信息
			System.out.println(temp);
			//将temp后移， 一定小心
			temp = temp.next;
		}
	}
}

//定义HeroNode ， 每个HeroNode 对象就是一个节点
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next; //指向下一个节点
	//构造器
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//为了显示方法，我们重新toString
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	
}