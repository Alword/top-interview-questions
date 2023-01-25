package org.example;

import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode solution = null;
        ListNode current = null;
        var remains = 0;
        while(l1 != null || l2 != null){
            var val1 = l1 == null ? 0 : l1.val;
            var val2 = l2 == null ? 0 : l2.val;
            var sum = (val1 + val2 + remains) % 10;
            remains = (val1 + val2 + remains) / 10;
            var result = new ListNode(sum);
            if(solution == null){
                solution = result;
            }
            else {
                current.next = result;
            }
            current = result;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(remains > 0){
            current.next = new ListNode(remains);
        }
        return solution;
    }
}