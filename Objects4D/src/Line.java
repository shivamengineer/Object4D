import components.map.Map;

/**
 *
 * @author Shivam Engineer
 *
 */
public interface Line extends LineKernel {

    /**
     *
     * @param dimensions
     * @param time
     */
    void translateLineAtTime(int[] dimensions, int time);

    /**
     *
     * @param dimensions
     * @param time
     */
    void setNewLineCoordinates(int[] dimensions, int time);

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
     * @param l
     * @return equal
     */
    boolean equals(Line l);

    //can add change to non-linear path

}
