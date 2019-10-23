package com.jc.leetcode;

import com.jc.leetcode.struct.ListNode;

import java.util.Stack;

/**
 * K 个一组翻转链表
 *
 *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjian on 2019/10/23
 */
public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        System.out.println(reverseKGroup(first, 3));
        System.out.println(reverseKGroup1(first, 3));
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (null == head){
            return null;
        }
        ListNode result = null;
        ListNode resultIndex = null;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (!(head == null && stack.size() != k)){
            if (stack.size() == k){
                while (!stack.empty()){
                    if (result == null){
                        result = stack.pop();
                        resultIndex = result;
                    }
                    if (!stack.empty()) {
                        resultIndex.next = stack.pop();
                        resultIndex = resultIndex.next;
                    }
                }
            }
            if (head != null) {
                stack.push(head);
                head = head.next;
            }
        }
        if (stack.empty()){
            resultIndex.next = null;
        }
        while (!stack.empty()){
            ListNode node = stack.pop();
            if (stack.empty()){
                if (result == null){
                    result = node;
                } else {
                    resultIndex.next = node;
                }
            }
        }

        return result;
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        ListNode cur = head;
        int count = 0;

        while(cur!=null){
            ListNode rear = cur.next;
            count++;
            if(count==k){
                pre = reverse1(pre,rear);
                count=0;
            }
            cur = rear;
        }
        return root.next;

    }

    public static ListNode reverse1(ListNode pre,ListNode end){
        if(pre==null||pre.next==null){
            return pre;
        }
        ListNode head = pre.next;
        ListNode cur = pre.next.next;

        while(cur!=end){
            ListNode rear = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = rear;
        }
        head.next = end;
        return head;

    }
}
