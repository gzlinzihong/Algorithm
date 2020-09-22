import cn.ilanky.stack.MyStack;
import org.junit.Test;

/**
 * @author ilanky
 * @date 2020年 09月22日 20:41:25
 */
public class StackTest {

    @Test
    public void testStack(){
        MyStack<String> stack = new MyStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        print(stack);

        String pop = stack.pop();
        System.out.println(pop);
        System.out.println("=================");

        print(stack);
    }

    public void print(MyStack stack){
        for (Object o : stack) {
            System.out.println(o);
        }
    }
}
