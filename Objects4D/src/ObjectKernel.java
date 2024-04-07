import components.standard.Standard;

/**
 *
 * @author Shivam Engineer
 *
 */
public interface ObjectKernel extends Standard<Object> {

    /**
     *
     * @param time
     * @return coords
     */
    int[] getObjectCoordinates(int time);

    /**
     * @param line
     * @param time
     * @param numVertices
     */
    void createObjectFrame(int[] line, int time, int numVertices);

    /**
     * @return dimensions
     */
    int getDimensions();

    /**
     * @return this.lines[]
     */
    Line[] getLines();

    /**
     * @return numVertices
     */
    int getNumVertices();

}
