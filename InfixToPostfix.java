import java.util.Scanner;

public class InfixToPostfix
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner (System.in);

        System.out.println("Please enter expression> ");
        String expression = input.nextLine();

        System.out.println(convertExpression(expression));

        System.out.println("the result is> "+calcPostFix(convertExpression(expression)));

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
        Stack<Integer> st = new Stack<Integer>();
        char c;
        String result="";
        int y =0;
        int x=0;
        int r =0;

        for(int i=0; i<PostFix.length(); i++)
        {
            c = PostFix.charAt(i);

            //if there is a digits in the string, it gets pushed to the stack
            if(Character.isDigit(c))
            {
                //parsing it from char to int
                int t = Character.getNumericValue(c);
                st.push(t);

            }

            else if (c=='+')
            {
                x = st.pop();
                y=st.pop();
                r=x+y;
                st.push(r);
            }
            else if (c=='-')
            {
                x=st.pop();
                y=st.pop();
                r=x-y;
                st.push(r);
            }
            else if(c=='*')
            {
                x=st.pop();
                y=st.pop();
                r=x*y;
                st.push(r);
            }


        }
        return r;
    }


}
