import components.map.Map;
import components.sequence.Sequence1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author Shivam Engineer
 */
public interface Point extends PointKernel {

    /**
     *
     * @param translateDistance
     * @param time
     */
    void translatePointAtTime(int time, int[] translateDistance);

    /**
     *
     * @param newCoordPosition
     * @param time
     */
    void setNewPointCoordinates(int time, int[] newCoordPosition);

    /**
     *
     * @param time
     * @return previousFrame
     */
    Map.Pair<Integer, Sequence1L<Integer>> previousPositionFrame(int time);

    /**
     *
     * @param time
     * @return nextFrame
     */
    Map.Pair<Integer, Sequence1L<Integer>> nextPositionFrame(int time);

    /**
     * .
     *
     * @param p
     * @return equal
     */
    boolean equals(Point p);

    //can add change to non-linear path

}
