package CheckParenthesis;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.*;

class CheckParenthesis {
    public static void main(String[] args) {
        String paranthesis = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the parenthesis string \n");
        try {
            paranthesis = sc.next();
        } catch (InputMismatchException e) {
            System.out.print("Please Enter A Valid String");
        }
        sc.close();

        int lengthOfString = paranthesis.length();
        if (lengthOfString % 2 != 0) {
            System.out.println("The input is invalid");
        } else {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < paranthesis.length(); i++) {
                char c = paranthesis.charAt(i);
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                }else{
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                        System.out.println("The string is invalid");
                        break;
                    }else if(stack.isEmpty()){
                        System.out.println("The string is valid");
                        break;
                    }
                }
            }
        }

    }
}