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

    /**
     *
     */
    @Test
    public final void testGetCoords() {
        Point p = this.constructorTest();
        Integer[] pos = { 0, 0, 0 };
        Integer[] pos2 = { 8, 8, 8 };
        p.createNewFrame(0, pos);
        p.createNewFrame(4, pos2);
        int len = p.getTimes().length();
        int lenExpected = 2;
        Integer[] getPos = p.getPosition(0);
        Integer[] getPos2 = p.getPosition(4);
        assertEquals(lenExpected, len);
        assertEquals(pos[0], getPos[0]);
        assertEquals(pos2[0], getPos2[0]);
        assertEquals(pos[1], getPos[1]);
        assertEquals(pos2[1], getPos2[1]);
        assertEquals(pos[2], getPos[2]);
        assertEquals(pos2[2], getPos2[2]);
    }

}
