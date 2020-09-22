import cn.ilanky.list.MyLinkedList;
import cn.ilanky.list.MyList;
import cn.ilanky.list.SequenceList;
import cn.ilanky.list.TwoWayLinkedList;
import org.junit.Test;

/**
 * @author ilanky
 * @date 2020年 09月22日 15:39:45
 */
public class ListTest {

    @Test
    public void testTwoWayLinkedList(){
        doTest(new TwoWayLinkedList());
    }

    @Test
    public void testMyLinkedList(){
        MyLinkedList list = new MyLinkedList();
        doTest(list);
        list.reverse();
        print(list);
    }

    @Test
    public void testSequenceList(){
        SequenceList<String> list = new SequenceList<String>(10);
        doTest(list);
    }

    public void doTest(MyList list){
        list.insert("张三");
        list.insert("李四");
        list.insert("王五");
        print(list);

        list.insert(2,"哈哈");

        print(list);

        System.out.println("index:"+list.indexOf("李四"));

        System.out.println("index 3:"+list.get(3));

        System.out.println("indexOf:"+list.indexOf("哈哈"));

        Object remove = list.remove(2);
        System.out.println("remove: "+remove);

//        list.clear();
//        print(list);
    }

    public void print(MyList list){
        for (Object o:list){
            System.out.println(o);
        }
        System.out.println("========================");
    }


}
