/**
 * .
 *
 * @author Shivam Engineer
 */
public final class Line2 extends LineSecondary {

    /**
    *
    */
    private Point point1;

    /**
    *
    */
    private Point point2;

    /**
     *
     */
    private int dimensions;

    /**
     * No argument constructor--private to prevent instantiation.
     */
    public Line2() {
        this.dimensions = Constants.THREE;
        this.point1 = new Point2();
        this.point2 = new Point2();
    }

    /**
     *
     * @param time
     * @return coords
     */
    @Override
    public int[] getLineCoordinates(int time) {
        int[] lineCoords = new int[this.dimensions * 2];
        for (int i = 0; i < this.dimensions; i++) {
            lineCoords[i] = this.point1.getPointCoordinates(time)[i];
        }
        for (int i = this.dimensions; i < this.dimensions * 2; i++) {
            lineCoords[i] = this.point2.getPointCoordinates(time)[i
                    - this.dimensions];
        }
        return lineCoords;
    }

    /**
     *
     * @param pointCoords
     */
    @Override
    public void createLineFrame(int[] lineCoords, int time) {
        assert lineCoords.length == this.dimensions * 2;

        if (this.point1.getOrderedTimes().length() == 0) {
            this.dimensions = lineCoords.length / 2;
        }

        int[] point1Coords = new int[this.dimensions];
        int[] point2Coords = new int[this.dimensions];
        for (int i = 0; i < this.dimensions; i++) {
            point1Coords[i] = lineCoords[i];
        }
        for (int i = this.dimensions; i < this.dimensions * 2; i++) {
            point2Coords[i - this.dimensions] = lineCoords[i];
        }
        this.point1.createPointFrame(point1Coords, time);
        this.point2.createPointFrame(point2Coords, time);
    }

    @Override
    public Point getPoint1() {
        return this.point1;
    }

    @Override
    public Point getPoint2() {
        return this.point2;
    }

    @Override
    public int getDimensions() {
        return this.dimensions;
    }

    @Override
    public void clear() {
        this.point1.clear();
        this.point2.clear();
    }

    @Override
    public Line newInstance() {
        return new Line2();
    }

    @Override
    public void transferFrom(Line source) {
        this.point1 = source.getPoint1();
        this.point2 = source.getPoint2();
        source.clear();
    }

}
