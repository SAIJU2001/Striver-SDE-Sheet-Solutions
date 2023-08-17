//striver

/*      61. Rotate List
Medium
8.5K
1.4K
Companies
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
 
Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/

import java.util.*;

//leetcode solution
class Solution 
{
    public ListNode rotateRight(ListNode head, int k) 
    {    
        if( head == null || head.next == null )
        {
           return head;
        }

        int count=0;
        ListNode curr=head;
        
        //first determin the length of the linked list
        while( curr!=null )
        {
            count++;
            curr=curr.next;
        }
        
        k%=count;   //if k is greater than length
        if( k==0 || k==count )
        {
            //if value of k is none or same as size of LL
            return head;
        }
        
        curr=head;
        ListNode prev=head;
        
        //three operations are perform 
        //goes to the length-k node and made next of that node is null
        //after that node goes to the last node and connect to the head
        //and after that length-k node is new head
        for( int i=0 ; i<=count-k-1 ; i++ )
        {
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        ListNode temp=curr;
        
        while(temp.next!=null )
        {
            temp=temp.next;
        }
        temp.next=head;
        head=curr;

        return head;
    }
}



//driver code
class ListNode 
{
    int val;
    ListNode next;

    public ListNode( int val)
    {
        this.val=val;
        this.next=null;
    }
}
public class RotateList
{
    static class LinkedList
    {
        ListNode head;
        ListNode tail;

        // add node last to the linked list
        public void addLast( int data)
        {
            ListNode newNode = new ListNode(data);
            if( head==null )
            {
                head=tail=newNode;
                return;
            }

            tail.next=newNode;
            tail=newNode;
        }

        // print the linked list
        public void printList()
        {
            if( head==null )
            {
                System.out.println("The linked list is empty.");
            }

            ListNode currNode=head;
            while( currNode != null )
            {
                System.out.print(currNode.val+" => ");
                currNode=currNode.next;
            }
            System.out.println("null"); 
        }
    }

    //main method
    public static void main(String args[])
    {
        Scanner Sc = new Scanner(System.in);
        int t=Sc.nextInt();
        while( t-->0 )
        {
            LinkedList list = new LinkedList();
            int n=Sc.nextInt();     //enter how many value you can add the linked list

            for( int i=0 ; i<n ; i++ )
            {
                int data=Sc.nextInt();      //enter the value;
                list.addLast( data); 
            }
            int k=Sc.nextInt();

            Solution sl=new Solution(); 
            list.head= sl.rotateRight( list.head, k);
            list.printList();
        }   
    }
}


    