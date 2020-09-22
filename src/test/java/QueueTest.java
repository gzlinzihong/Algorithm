import cn.ilanky.queue.MyQueue;
import org.junit.Test;

/**
 * @author ilanky
 * @date 2020年 09月22日 21:50:37
 */
public class QueueTest {

    @Test
    public void testQueue(){
        MyQueue<String> queue = new MyQueue<>();

        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");

        print(queue);
        System.out.println("==================");

        String dequeue = queue.dequeue();
        System.out.println("dequeue:"+dequeue);

        System.out.println("=================");
        print(queue);
    }

    public void print(MyQueue queue){
        for (Object o : queue) {
            System.out.print(o+" ");
        }
    }
}
