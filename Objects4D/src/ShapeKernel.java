import components.map.Map;
import components.standard.Standard;

/**
 *
 * @author Shivam Engineer
 *
 */
public interface ShapeKernel extends Standard<Shape> {

    /**
     *
     * @param time
     * @param position
     */
    void createNewFrame(int time, Integer[] position);

    /**
     *
     * @param time
     * @return frame
     */
    Map.Pair<Integer, Integer[]> removeFrame(int time);

    /**
     *
     * @param time
     * @return position
     */
    Integer[] getPosition(int time);

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
