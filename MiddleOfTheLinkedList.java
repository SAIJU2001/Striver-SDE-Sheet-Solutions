//striver

/*      876. Middle of the Linked List
Easy
10.3K
299
Companies
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 
Constraints:
The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
*/

import java.util.*;

class ListNode 
{
    int val;
    ListNode next;

    public ListNode( int val ) 
    { 
        this.val = val;
        this.next=null; 
    }
}

//solution of the leetcode problem
class Solution 
{
    public ListNode middleNode(ListNode head) 
    {    
        int count=0;        //count the length of the linked list
        ListNode curr=head;

        while( curr!=null )
        {
            //this loops runs until the node is null
            count++;
            curr=curr.next;
        }

        //for mid we should run a lopp of length/2
        count=count/2;
        curr=head;
        for( int i=0 ; i<count ; i++ )
        {
            curr=curr.next;
        }
        return curr;
    }
}


//driver code
public class MiddleOfTheLinkedList
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

            Solution sl=new Solution(); 
            list.head= sl.middleNode( list.head );
            list.printList();
        }   
    }
}


    