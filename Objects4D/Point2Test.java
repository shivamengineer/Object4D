/**
 * Customized JUnit test fixture for {@code List3}.
 */
public class Point2Test extends PointTest {

    @Override
    protected final Point constructorTest() {
        return new Point2(Constants.THREE);
    }

}
