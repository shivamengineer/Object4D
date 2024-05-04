/**
 * Simple Point program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author Shivam Engineer
 */
public interface Point extends PointKernel {

    /**
     *
     * @param time
     * @param translateDistance
     */
    void translateFrame(int time, Integer[] translateDistance);

    /**
     *
     * @param time
     * @param newCoords
     */
    void setFramePosition(int time, Integer[] newCoords);

    /**
     *
     * @param time
     * @return position
     */
    Integer[] getPositionBetweenFrames(int time);

}
