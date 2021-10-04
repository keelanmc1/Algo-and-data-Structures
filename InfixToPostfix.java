import java.util.Scanner;

public class InfixToPostfix
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in);

        System.out.println("Please enter expression> ");
        String expression = input.nextLine();

        System.out.println(convertExpression(expression));

        System.out.println(calcPostFix(convertExpression(expression)));

    }
    //method to dermine precendence amongst the operators in the expression
    private static int precedence(char c )
    {
        switch (c)
        {
            case '+':
                return 1;
            case '-':
                return 0;
            case '*':
                return -1;
        }
        return c;
    }

    private static String convertExpression(String exp)
    {
        Stack<Character> st = new Stack<Character>();

        char c='\0';
        String result="";

       for(int i=0; i<exp.length(); i++)
       {
           c = exp.charAt(i);

           //if c contains either a letter or digit, it gets put into the output
           if(Character.isLetterOrDigit(c))
       {
           result += String.valueOf(c);
       }
           //if there is an opening delimiter, push it to the stack
          else if(c=='(')
           {
               st.push(c);
           }

          //if there is any operators in expression, they get pushed to the stack
           else if(c=='-' || c=='+' || c=='*')
           {
               st.push(c);
           }

           //if there is a closing delimiter and the top of the stack isnt an opening delimiter
           if(c==')' &&st.peek()!='(')
           {
                   result += String.valueOf(st.pop());
                   st.clear();

           }

       }
       while(!st.isEmpty())
       {
           result +=st.pop();
       }


       return result;


    }

    //function that is going to be used to calculate the postfix expression
    private static int calcPostFix(String PostFix)
    {
        Stack<Character> st = new Stack<Character>();
        char c;
        String result="";
        int num1;
        int total=0;
        char operator;

        for(int i=0; i<PostFix.length(); i++)
        {
            c = PostFix.charAt(i);

            //if there is a digits in the string, it gets pushed to the stack
            if(Character.isLetterOrDigit(c))
            {
                st.push(c);


            }
            //if there is any operator encountered, parse the char into an int and pop from the stack
            if(c=='+' || c=='-' || c=='*')
            {
                //i then use the numeric value to calculate the result
                //problem is that i dont know how to use the operator in the calculation..

                //TODO find a way to calculate the numbers from the stack with the encountered operator

                num1 = Character.getNumericValue(st.pop());
                operator = c;
                total = num1 +operator ;
            }
        }
        return total;
    }


}
