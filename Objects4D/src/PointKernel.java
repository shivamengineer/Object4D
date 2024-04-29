import components.map.Map;
import components.sequence.Sequence;
import components.sequence.Sequence1L;
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
    void createPointFrame(int time, int[] point);

    /**
     * @param time
     * @return pointFrame
     */
    Map.Pair<Integer, Sequence1L<Integer>> removePointFrame(int time);

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
    Map<Integer, Sequence1L<Integer>> getPositionFrames();

}
