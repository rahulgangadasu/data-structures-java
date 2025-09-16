package dsa;

import java.util.Arrays;

public class ArrayQueue {
    private int [] items;
    private int rear;
    private int front;
    private int count = 0;

    public ArrayQueue(int capacity){
        items = new int[capacity];
    }
    public void enqueue(int value){
        if( count == items.length)
        throw new IllegalArgumentException();

        items[rear] = value;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue(){
        int item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);  
    }
}
