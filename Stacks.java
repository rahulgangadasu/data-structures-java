package dsa;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        String str = "luhar";
        //String Reversal.
        Stack <Character> stk = new Stack<>();
        for(char ch : str.toCharArray()){
            stk.push(ch);
        }
        StringBuffer reversed = new StringBuffer();
        while(!stk.empty())
            reversed.append(stk.pop());
        System.out.println(reversed);

        //Matching Braces.
        String exp = "[{1 + 2( 3 + 4) }< 5 + 6> (9 -3) {7  * 5} 4 % 8]";
        Stack <Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if(ch == '[' || ch == '(' || ch == '{' || ch == '<')
                stack.push(ch);
            if(ch == ']' || ch == ')' || ch == '}' || ch == '>')
                stack.pop();
        }
        System.out.println(stack.empty());
    }
}
