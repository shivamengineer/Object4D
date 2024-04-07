import components.map.Map;
import components.sequence.Sequence;
import components.standard.Standard;

/**
 *
 * @author Shivam Engineer
 *
 */
public interface PointKernel extends Standard<Point> {

    /**
     *
     * @param time
     * @return coords
     */
    int[] getPointCoordinates(int time);

    /**
     * @param point
     * @param time
     */
    void createPointFrame(int[] point, int time);

    /**
     * @param time
     * @return pointFrame
     */
    Map.Pair<Integer, int[]> removePointFrame(int time);

    /**
     * @param time
     * @return index
     */
    int findTimeIndex(int time);

    /**
     * @return dimensions
     */
    int getDimensions();

    /**
     * @return times
     */
    Sequence<Integer> getOrderedTimes();

    /**
     * @return positions
     */
    Map<Integer, int[]> getPositionFrames();

}
