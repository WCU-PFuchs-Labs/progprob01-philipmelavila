/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/

import java.util.Scanner;

public class homework20_1
{
   public static void main(String[] args)
   {
      LinkedList list = new LinkedList();
      Scanner scanner = new Scanner(System.in);
      System.out.println("Please enter five integers:");

      for (int i = 0; i < 5; i++) {
         System.out.print("Enter integer " + (i + 1) + ": ");
         int number = scanner.nextInt();


         ListNode newNode = new ListNode(number);
         if (list.head == null) {
            list.head = newNode;
         } else {
            ListNode current = list.head;
            while (current.next != null) {
               current = current.next;
            }
            current.next = newNode;
         }
      }

      scanner.close();
      deleteDuplicates(list);
      System.out.println(list.toString());
   
   }
   public static void deleteDuplicates(LinkedList llist)
   {
      // If llist length is either 0 or 1 (means there is no duplicates)
      if (llist.head == null || llist.head.next == null) {
         return;
      }

      ListNode current = llist.head;

      // will stop @ current being the last node or the list is done
      while (current != null && current.next != null) {

         // Will remove pointer to current.next and point it to the one two ahead
         if (current.value == current.next.value) {
            current.next = current.next.next;
         } else {
            current = current.next;
         }
      }
   }

}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){value = v;}
}

class LinkedList
{
   ListNode head;
   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }
}
