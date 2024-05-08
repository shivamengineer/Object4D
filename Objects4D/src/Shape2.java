import components.map.Map;

/**
 *
 * @author Shivam Engineer
 *
 */
public final class Shape2 extends ShapeSecondary {

    /**
     *
     */
    private Point[] points;

    /**
     *
     */
    private int dimensions;

    /**
     * @param d
     */
    public Shape2(int d) {
        this.dimensions = d;
        this.points = new Point[d];
        for (int i = 0; i < d; i++) {
            this.points[i] = new Point2(d);
        }
    }

    @Override
    public void createNewFrame(int time, Integer[] position) {

    }

    @Override
    public Map.Pair<Integer, Integer[]> removeFrame(int time) {
        return null;
    }

    @Override
    public Integer[] getPosition(int time) {
        return null;
    }

    @Override
    public int getDimensions() {
        return this.dimensions;
    }

    @Override
    public Point[] getPoints() {
        return this.points;
    }

    /**
     *
     */
    private void createNewRep() {
        for (int i = 0; i < this.dimensions; i++) {
            this.points[i].clear();
        }
        this.dimensions = Constants.THREE;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Shape newInstance() {
        return new Shape2(Constants.THREE);
    }

    @Override
    public void transferFrom(Shape s) {
        this.dimensions = s.getDimensions();
        this.points = s.getPoints();
        s.clear();
    }

}
