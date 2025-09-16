public class LinkedList{
    class Node{
        int value;
        Node next;
        public Node(int value){ this.value = value;}
    }

    private Node head;
    private Node tail;
    private int length;
    public LinkedList(int value){
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
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail  = newNode;
        }
        length++;
    }
    public Node removeLast(){
        Node temp = head;
        Node pre = head;
        if (length == 0) return null;
        else{
            while(temp.next != null){
                pre = temp;
                temp = temp.next;
            }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0){
            head = null;
            tail = null;
        }
        }
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        } 
        length++;
    }

    public Node removeFirst(){
        Node temp = head;
        if(length == 0) return null;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) tail = null;
        return temp;
    }

    public Node getNode(int index){
        if(index < 0 || index > length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean setNode(int index, int value){
        Node temp = getNode(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insertNode(int index, int value){
        Node newNode = new Node(value);
        if(index < 0 || index > length) return false;
        else if( index == 0) {prepend(value); return true;}
        else if(index == length){ append(value); return true;}
        else{
            Node temp = getNode(index-1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            return true;
        }
    }
    public Node remove(int index){
        if(index < 0 || index > length) return null;
        else if(index == 0) return removeFirst();
        else if(index == length) return removeLast();
        Node prev = getNode(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i =  0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
}