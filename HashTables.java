package dsa;

public class HashTables {
    public static void main(String[] args) {
        CharacterFinder  characterFinder = new CharacterFinder();
        System.out.println(characterFinder.findFirstNonRepeatingCharacter("raahhuullreeddy"));
        System.out.println(characterFinder.firstRepeatedCharacter("rahul reddy"));

        HashTableDemo hashTable = new HashTableDemo();
        hashTable.put(7, "rahul");
        hashTable.put(9, "reddy");
        hashTable.put(2, "gangadasu");
        System.out.println(hashTable.get(9));
    }
}
