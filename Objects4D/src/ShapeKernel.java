import components.standard.Standard;

/**
 *
 * @author Shivam Engineer
 *
 */
public interface ShapeKernel extends Standard<Shape> {

    /**
     *
     * @return this.dimensions
     */
    int getDimensions();

    /**
     *
     * @return this.points
     */
    Point[] getPoints();

}
