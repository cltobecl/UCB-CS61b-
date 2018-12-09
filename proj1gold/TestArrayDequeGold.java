import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void arrayDequeTest(){
        ArrayDequeSolution<Integer> expected = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<>();

        for(int i = 0; i < 100; i += 1){
            int flag = StdRandom.uniform(0,4);
            Integer val = Integer.valueOf(StdRandom.uniform(100));

            if(flag == 0){
                System.out.println("addFirst(" + val + ")");
                expected.addFirst(val);
                actual.addFirst(val);
            }
            else if(flag == 1){
                System.out.println("addLast(" + val + ")");
                expected.addLast(val);
                actual.addLast(val);
            }
            else if(flag == 2){
                if(!expected.isEmpty()){
                    System.out.println("removeFirst()");
                    assertEquals(expected.isEmpty(), actual.isEmpty());
                    Integer exp = expected.removeFirst();
                    Integer ac = actual.removeFirst();
                    assertEquals("removeFirst()", exp, ac);
                }
            }
            else{
                if(!expected.isEmpty()){
                    System.out.println("removeLast()");
                    assertEquals(expected.isEmpty(), actual.isEmpty());
                    Integer exp = expected.removeLast();
                    Integer act = actual.removeLast();
                    assertEquals( "removeLast()" ,exp, act);
                }
            }

        }

    }


}
