package dsa;

public class TriesWithArray {
    public static int ALPHABET_SIZE = 26;

    private class TrieNode{
        private char value;
        private TrieNode [] children = new TrieNode[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public TrieNode(char value) {
            this.value = value;
        }     
        @Override
        public String toString() {
            return "value : " + value;
        }
    }
    private TrieNode root = new TrieNode(' ');
    public void insert(String word){
        var current = root;
        for (char ch : word.toCharArray()) {
            var index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(ch);
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }
    }
}
