class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head.next == null)
             return true;
        
        ListNode slow = head;
        ListNode fast = head;

        Stack<Integer> st = new Stack<>();

        while(fast != null)
        {
            st.push(slow.val);
            if(fast.next == null)
            {
                fast = null;
                st.pop();
            
            }
            else 
                fast = fast.next.next;

            slow = slow.next;
        }

        while(slow != null)
        {
            int v = st.pop();

            if(slow.val != v)
                return false;
            
            slow = slow.next;
        }

        return true;

    }
}