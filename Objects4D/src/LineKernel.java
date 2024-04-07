import components.standard.Standard;

/**
 *
 * @author Shivam Engineer
 *
 */
public interface LineKernel extends Standard<Line> {

    /**
     *
     * @param time
     * @return coords
     */
    int[] getLineCoordinates(int time);

    /**
     * @param lineCoords
     * @param time
     */
    void createLineFrame(int[] lineCoords, int time);

    /**
     * @return dimensions
     */
    int getDimensions();

    /**
     * @return this.point1
     */
    Point getPoint1();

    /**
     * @return this.point2
     */
    Point getPoint2();

}
