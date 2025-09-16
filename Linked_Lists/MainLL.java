public class MainLL {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList(5);
         myLinkedList.append(15);
         myLinkedList.append(20);
         myLinkedList.PrintList();
         myLinkedList.removeLast();
         myLinkedList.PrintList();
         myLinkedList.prepend(3);
         myLinkedList.prepend(18);
         myLinkedList.PrintList();
         myLinkedList.removeFirst();
         myLinkedList.PrintList();
         System.out.println(myLinkedList.setNode(1, 10));
         System.out.println(myLinkedList.insertNode(3, 25));
         System.out.println(myLinkedList.insertNode(1, 30));
         myLinkedList.PrintList();
         myLinkedList.remove(2);
         myLinkedList.PrintList();
         myLinkedList.reverse();
         myLinkedList.PrintList();

    }
}
