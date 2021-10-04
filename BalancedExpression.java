import java.util.Scanner;
public class BalancedExpression
{
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an expression: ");
        String expression = input.next();

        System.out.println("is the expression balanced? "+balancedExpression(expression));
    }

    private static boolean balancedExpression(String exp)
    {
       char nextChar;
       char openDelimiter;

       boolean isBalanced = true;

       Stack<Character> stack = new Stack<Character>();

       while(isBalanced && exp.length()>0)
       {
           nextChar = exp.charAt(0);

           switch (nextChar){
               case '(':
               case'[':
               case'{':{
                   stack.push(nextChar);
                   break;
               }

               case')':
               case']':
               case'}':
               {
                   if(stack.isEmpty()) isBalanced=false ;

                   else
                   {
                       openDelimiter = stack.pop();
                       if(openDelimiter== '(' &&nextChar !=')' || openDelimiter=='[' &&nextChar!=']'
                               || openDelimiter=='{'&&nextChar!='}')
                       {
                           isBalanced =false;
                       }
                   }
                   break;
               }
           }

           if(exp.length()>1) exp = exp.substring(1);
           else exp = "";
       }

       if(!stack.isEmpty()) isBalanced = false;
       return isBalanced;

    }
}