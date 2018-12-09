import static org.junit.Assert.*;
import org.junit.Test;
public class FlikTest {
    @Test
    public void testIsSameNumber(){
        Integer a = Integer.parseInt("129");
        Integer b = Integer.parseInt("129");

        assertTrue("integer 129 == integer  129 ?", Flik.isSameNumber(a ,b));

        assertTrue("10 == 10?", Flik.isSameNumber(10, 10));
        assertTrue("127 == 127 ?", Flik.isSameNumber(127, 127));
        assertTrue( "129 = 129?",Flik.isSameNumber(129,129));
    }
}
