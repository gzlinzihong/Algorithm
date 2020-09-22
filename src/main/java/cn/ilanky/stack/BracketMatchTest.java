package cn.ilanky.stack;

/**
 * @author ilanky
 * @date 2020年 09月22日 20:45:55
 */
public class BracketMatchTest {
    public static void main(String[] args) {
        String str = "上海((aa(bbb)(12))";
        System.out.println(isMatch(str));
    }

    public static boolean isMatch(String str){
        MyStack<String> stack = new MyStack<>();
        for (char c : str.toCharArray()) {
            if (c == '('){
                stack.push(String.valueOf(c));
            }else if (c == ')'){
                String pop = stack.pop();
                if (pop == null){
                    return false;
                }
            }
        }

        if (stack.size()>0){
            return false;
        }

        return true;
    }
}
