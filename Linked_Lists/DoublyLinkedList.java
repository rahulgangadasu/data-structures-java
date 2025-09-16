public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    class Node{
        Node next;
        Node prev;
        int value;
        Node(int value){
            this.value = value;
        }
    }
    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void PrintList(){
        Node temp = head;
        System.out.print("[");
        while(temp != null){
            System.out.print(temp.value + ",");
            temp = temp.next;
        }
        System.out.println("\b]");
    }

    public void getHead(){
        System.out.println("Head : " + head.value); 
    }
    public void getTail(){
        System.out.println("Tail : " + tail.value);
    }
    public void getLength(){
        System.out.println("Length : " + length);
    }

    public void append(){
        
    }
}
