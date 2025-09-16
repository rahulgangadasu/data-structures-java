package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tries {

    private class TrieNode{
        private char value;
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isEndOfWord;

        public TrieNode(char value) {
            this.value = value;
        }     
        @Override
        public String toString() {
            return "value : " + value;
        }

        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }

        public void addChild(char ch){
            children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch){
            return children.get(ch);
        }

        private TrieNode[] getChildren(){
            return children.values().toArray(new TrieNode[0]);
        }
        public boolean hasChildren(){
            return !children.isEmpty();
        }

        public void removeChild(char ch){
            children.remove(ch);
        }
    }
    private TrieNode root = new TrieNode(' ');
    public void insert(String word){
        var current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) 
                current.addChild(ch);
            current = current.getChild(ch);
            current.isEndOfWord = true;
        }
    }

    public boolean contains(String word){
        if (word == null) return false;
        var current = root;
        for (char ch : word.toCharArray()) {
            if(!current.hasChild(ch)) return false;
            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traverse(){
        traverse(root);
    }
    private void traverse(TrieNode root){
        System.out.print(root.value + " "); //pre-order Traversal
        for (var child : root.getChildren()) {
            traverse(child);
        }
    }
    public void remove(String word){
        if(word == null) return;
        remove(root, word, 0);
    }
    private void remove(TrieNode root, String word, int index){
        if(index == word.length()){
            root.isEndOfWord = false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch); 
        if(child == null) return;

        remove(child, word, index + 1);
        if(!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);
    }

    public List <String> findWords(String prefix){
        List <String> words = new ArrayList<>();
        var lastNode = findLasTrieNode(prefix);
        findWords(lastNode, prefix, words);
        return words;
    }

    private void findWords(TrieNode root, String prefix, List <String> words){
        if(root == null) return;
        if(root.isEndOfWord) words.add(prefix);
        for (var child : root.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    private TrieNode findLasTrieNode(String prefix){
        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if(child == null) return null;
            current = child;
        }
        return current;
    }
}
