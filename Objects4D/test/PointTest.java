import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code List<String>}'s constructor and kernel methods.
 *
 * @author Liam Resnick and Shivam Engineer
 *
 */
public abstract class PointTest {

    /**
     *
     * @return the new point
     */
    protected abstract Point constructorTest();

    /**
     *
     */
    @Test
    public final void testConstructor() {
        Point p = this.constructorTest();
        Point p2 = new Point2(Constants.THREE);
        assertEquals(p2, p);
    }

    /**
     *
     */
    @Test
    public final void testCreateFrame() {
        Point p = this.constructorTest();
        Integer[] pos = { 0, 0, 0 };
        p.createNewFrame(0, pos);
        int len = p.getTimes().length();
        int lenExpected = 1;
        assertEquals(lenExpected, len);
    }

    /**
     *
     */
    @Test
    public final void testRemoveFrame() {
        Point p = this.constructorTest();
        Integer[] pos = { 0, 0, 0 };
        p.createNewFrame(0, pos);
        p.removeFrame(0);
        int len = p.getTimes().length();
        int lenExpected = 0;
        assertEquals(lenExpected, len);
    }

}
