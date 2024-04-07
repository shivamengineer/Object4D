import components.map.Map;

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
    void translatePointAtTime(int[] translateDistance, int time);

    /**
     *
     * @param newCoordPosition
     * @param time
     */
    void setNewPointCoordinates(int[] newCoordPosition, int time);

    /**
     *
     * @param time
     * @return previousFrame
     */
    Map.Pair<Integer, int[]> previousPositionFrame(int time);

    /**
     *
     * @param time
     * @return nextFrame
     */
    Map.Pair<Integer, int[]> nextPositionFrame(int time);

    /**
     * .
     *
     * @param p
     * @return equal
     */
    boolean equals(Point p);

    //can add change to non-linear path

}
