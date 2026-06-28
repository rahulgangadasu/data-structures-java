package dsa;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Queues{
    public static void reverse(Queue <Integer> queue){
        Stack <Integer> stack = new Stack<>();
        while(!queue.isEmpty())
            stack.push(queue.remove());
        while(!stack.empty())
            queue.add(stack.pop());
    }
    public static void main(String[] args) {
        Queue <Integer> queue = new ArrayDeque<>();
        queue.add(18);
        queue.add(20);
        queue.add(27);
        System.out.println(queue);
        Queues.reverse(queue);
        System.out.println(queue);

        ArrayQueue que = new ArrayQueue(6);
        que.enqueue(10);
        que.enqueue(20);
        que.enqueue(28);
        System.out.println(que);
        System.out.println(que.dequeue());

        QueueStacks qs = new QueueStacks();
        qs.enqueue(27);
        qs.enqueue(20);
        System.out.println(qs.dequeue());

        PriorityQueues pq = new PriorityQueues();
        pq.insert(5);
        pq.insert(4);
        pq.insert(1);
        System.out.println(pq);
    }
}
