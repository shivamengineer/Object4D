/**
 * Simple Shape program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author Shivam Engineer
 */
public interface Shape extends ShapeKernel {

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
     * @return position at time
     */
    Integer[] getPositionAtTime(int time);

}
