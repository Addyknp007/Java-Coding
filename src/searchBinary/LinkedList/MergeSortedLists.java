package searchBinary.LinkedList;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        // if(l1.val>l2.val){
        //     l2.next=mergeTwoLists(l1,l2.next);
        //     return l2;
        // }else{
        //     l1.next=mergeTwoLists(l1.next,l2);
        //     return l1;
        // }
        ListNode temp = null;
        while(l1!=null && l2!=null){
            if(l1.val>=l2.val){
                ListNode temp2 = new ListNode(l2.val);
                if(temp == null){
                    temp = temp2;
                }else{
                    temp.next = temp2;
                }
                temp = temp.next;

                l2 = l2.next;
            } else {
                ListNode temp2 = new ListNode(l1.val);
                if(temp == null){
                    temp = temp2;
                }else{
                    temp.next = temp2;
                }

                l1= l1.next;
                temp = temp.next;
            }
        }
        return temp;

    }


    // Helper function to print a linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeSortedLists merger = new MergeSortedLists();

        // Create two sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        // Merge the lists
        ListNode mergedList = merger.mergeTwoLists(l1, l2);

        // Print the merged list
        merger.printList(mergedList);
    }
}
