package dsa;

import java.util.Arrays;

public class PriorityQueues {
    private int [] priorityQueue = new int[5];
    private int count;

    public void insert(int value){
        int i ;
        for (i = count; i >= 0 ; i--) {
            if(priorityQueue[i] > value)
                priorityQueue[i + 1] = priorityQueue[i];
            else
                break;
        }
        priorityQueue[i + 1] = value;
        count++;
    }

    public int remove(){
        return priorityQueue[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(priorityQueue);  
    }
}
