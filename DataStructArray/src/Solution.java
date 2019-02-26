
/***
 * 括号是否有效的检测的类
 */
class Solution {
    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for(int i=0 ;i<s.length();i++){
            char c = s.charAt(i);
             if(c=='('||c=='['|| c=='{')
                 stack.push(c);
             else{
                 if (stack.isEmpty())
                     return false;
                char chartop =  stack.pop();
                if(c == ')' && chartop !='(')
                      return false;

                 if(c == ']' && chartop !='[')
                     return false;

                 if(c == '}' && chartop !='{')
                     return false;

             }

        }
        return   stack.isEmpty();
    }
     public static void main(String[] args){
        System.out.println(new Solution().isValid("()(){}[]"));
        System.out.println(new Solution().isValid("()(){}[]]]"));

     }
}