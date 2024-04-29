import components.map.Map;
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
     * @param pos
     */
    void createNewFrame(int time, Integer[] pos);

    /**
     *
     * @param time
     * @return removed frame
     */
    Map.Pair<Integer, Integer[]> removeFrame(int time);

}
