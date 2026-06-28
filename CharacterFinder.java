package dsa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterFinder {
    
    public char findFirstNonRepeatingCharacter(String string){
          Map <Character, Integer> map = new HashMap<>();
          char [] chars = string.toCharArray();
          for (char c : chars) {
           var count =  map.containsKey(c) ? map.get(c) : 0;
           map.put(c, count + 1);
          }
          for (char ch : chars) {
            if(map.get(ch) == 1)
                return ch;
          }
        return Character.MIN_VALUE;
    }

    public Character firstRepeatedCharacter(String string){
        char [] chars = string.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            if(set.contains(c))
                return c;
            set.add(c);
        }
        return Character.MIN_VALUE;
    }
}
