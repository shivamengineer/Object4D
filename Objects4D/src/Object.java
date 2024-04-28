import components.map.Map;

/**
 * .
 *
 * @author Shivam Engineer
 */
public interface Object extends ObjectKernel {
//change Object to something else to not confuse with Java Object
    /**
     *
     * @param dimensions
     * @param time
     */
    void translateObjectAtTime(int[] dimensions, int time);

    /**
     *
     * @param dimensions
     * @param time
     */
    void setNewObjectCoordinates(int[] dimensions, int time);

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
     * @param o
     * @return equal
     */
    boolean equals(Object o);

    //can add change to non-linear path

}
