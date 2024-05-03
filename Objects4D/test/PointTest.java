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
        Point p2 = new Point2(3);
        assertEquals(p2, p);
    }

}
