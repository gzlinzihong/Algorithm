package cn.ilanky.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ilanky
 * @date 2020年 09月22日 20:54:14
 * 逆波兰表达式(后缀表达式)
 */
public class ReversePolishNotationTest {
    public static void main(String[] args) {
        //3*(17-15)+18/6
        String str = "3*(17-15)+18/6";
        System.out.println(Arrays.toString(transfer(str)));
        String[] notation = {"3","17","15","-","*","18","6","/","+"};
        System.out.println(caculate(notation));
    }

    /**
     * 中缀转后缀
     * @param str
     * @return
     */
    public static String[] transfer(String str){
        List<String> notation = new ArrayList<>();
        MyStack<String> mask = new MyStack<>();
        for (char c : str.toCharArray()) {
            //如果是操作数，直接添加到集合
            if (c > '0' && c < '9'){
                notation.add(String.valueOf(c));
            }else if (c == '('){
                //左括号直接入栈
                mask.push(String.valueOf(c));
            }else if (c == ')'){
                //右括号则一直弹出，直到遇到左括号
                String s = null;
                while ((s = mask.pop()).equals("(") == false){
                    notation.add(s);
                }
            }else{
                //是运算符
                //如果堆栈为空或者栈顶是左括号或者运算符比栈顶元素优先级大，则直接入栈
                if ( mask.isEmpty() || "(".equals(mask.peek()) || priority(String.valueOf(c)) > priority(mask.peek()) ){
                    mask.push(String.valueOf(c));
                }else{
                    //如果比栈顶元素优先级小，则一直弹出栈顶，并重新入栈，直到队列为空或者碰到左括号或者栈顶元素优先级大与运算符
                    while (!mask.isEmpty() && !"(".equals(mask.peek()) && priority(String.valueOf(c)) <= priority(mask.peek())){
                        notation.add(mask.pop());
                    }
                    mask.push(String.valueOf(c));
                }
            }
        }
        while (!mask.isEmpty()){
            notation.add(mask.pop());
        }
        String[] strings = new String[notation.size()];
        return notation.toArray(strings);
    }

    public static int priority(String op){
        if ("*".equals(op) || "/".equals(op)){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 计算后缀表达式的值
     * @param notation
     * @return
     */
    public static int caculate(String[] notation){
        MyStack<Integer> operations = new MyStack<>();
        Integer i1 = null;
        Integer i2 = null;
        for (String s : notation) {
            switch (s){
                //如果是运算符，则弹出2个数并计算
                //由于是先进后出，因此减法/除法操作的话是弹出来的第二个数在前
                case "+":
                    i1 = operations.pop();
                    i2 = operations.pop();
                    operations.push(i1 + i2);
                    break;
                case "-":
                    i1 = operations.pop();
                    i2 = operations.pop();
                    operations.push(i2 - i1);
                    break;
                case "*":
                    i1 = operations.pop();
                    i2 = operations.pop();
                    operations.push(i1 * i2);
                    break;
                case "/":
                    i1 = operations.pop();
                    i2 = operations.pop();
                    operations.push(i2 / i1);
                    break;
                default:
                    operations.push(Integer.valueOf(s));
                    break;
            }
        }
        return operations.pop();
    }
}
