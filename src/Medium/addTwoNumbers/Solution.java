package Medium.addTwoNumbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry_on = 0;
        // The list will have an extra 0 at the start that's why we will return result.next
        ListNode result = new ListNode(0); // result will remain pointing at the same node
        ListNode current = result; // current will be the one moving in the list

        // Continue looping till both Linked lists point to null
        while(l1 != null || l2 != null){
            // To handle if one list is longer than the other
            int l1_val = (l1 != null) ? l1.val : 0; // If l1 is null, use 0
            int l2_val = (l2 != null) ? l2.val : 0; // If l2 is null, use 0

            int sumOfTwoDigits = l1_val + l2_val + carry_on;
            carry_on = sumOfTwoDigits/10;
            int last_digit = sumOfTwoDigits % 10;

            current.next = new ListNode(last_digit);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there's a remaining carry, add it as a new node
        if (carry_on > 0) {
            current.next = new ListNode(carry_on);
        }
        return result.next;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

