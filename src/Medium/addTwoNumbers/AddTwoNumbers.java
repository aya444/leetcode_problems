package Medium.addTwoNumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // ListNode l1 = new ListNode(); this will create a default node that has value 0, and we don't want that
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result linked list
        solution.printList(result); // Output: 7 -> 0 -> 8

    }
}

// [2,4,3]
// [5,6,4]
// -------
// [7,0,8]
