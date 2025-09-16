package dsa;

import java.util.LinkedList;
public class HashTableDemo {
    private class Entry{
        private int key;
        private String value;
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    @SuppressWarnings("unchecked")
    private LinkedList <Entry> [] entries = new LinkedList[5];
    

    public void put(int key, String value){
        var index = hash(key);
        if(entries[index] == null)
            entries[index] = new LinkedList<>();
        for (var entry : entries[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        entries[index].addLast(new Entry(key, value));
    }
    public int hash(int key){
        return key % entries.length;
    }
    public String get(int key){
        var index = hash(key);
        if (entries[index] != null) {
            for (var entry : entries[index]) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    public void remove(int key){
        var index = hash(key);
        if(entries[index] == null)
            throw new IllegalArgumentException();
        for (var entry : entries[index]) {
            if (entry.key == key) {
                entries[index].remove(entry);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
