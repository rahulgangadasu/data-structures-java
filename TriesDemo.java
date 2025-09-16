package dsa;

public class TriesDemo {
    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("cat");
        trie.insert("can");
        trie.insert("card");
        trie.insert("care");
        trie.insert("carl");
        trie.insert("bike");
        trie.insert("biker");
        System.out.println( trie.contains("carl"));
        Tries trie1 = new Tries();
        trie1.insert("canada");
        trie1.traverse();
        trie1.remove("canada");
        System.out.println();
        System.out.println( trie1.contains("canada"));
        System.out.println(trie.findWords("car"));
    }
}
