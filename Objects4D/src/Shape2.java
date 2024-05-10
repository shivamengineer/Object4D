import components.map.Map;
import components.map.Map1L;

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
     *
     */
    private int numVertices;

    /**
     * @param d
     * @param numberOfVertices
     */
    public Shape2(int d, int numberOfVertices) {
        this.dimensions = d;
        this.numVertices = numberOfVertices;
        this.points = new Point[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            this.points[i] = new Point2(d);
        }
    }

    @Override
    public void createNewFrame(int time, Integer[] position) {
        for (int i = 0; i < this.numVertices; i++) {
            Integer[] temp = new Integer[this.dimensions];
            int margin = i * this.dimensions;
            for (int j = 0; j < this.dimensions; i++) {
                temp[j] = position[margin + j];
            }
            this.points[i].createNewFrame(time, temp);

        }
    }

    @Override
    public Map.Pair<Integer, Integer[]> removeFrame(int time) {
        Map<Integer, Integer[]> tempMap = new Map1L<Integer, Integer[]>();
        Integer[] pos = new Integer[this.numVertices * this.dimensions];
        for (int i = 0; i < this.numVertices; i++) {
            Integer[] tempPos = this.points[i].removeFrame(time).value();
            int margin = i * this.dimensions;
            for (int j = 0; j < this.dimensions; j++) {
                pos[margin + j] = tempPos[j];
            }
        }
        tempMap.add(time, pos);
        return tempMap.remove(time);
    }

    @Override
    public Integer[] getPosition(int time) {
        Integer[] pos = new Integer[this.numVertices * this.dimensions];
        for (int i = 0; i < this.numVertices; i++) {
            Integer[] tempPos = this.points[i].getPosition(time);
            int margin = i * this.dimensions;
            for (int j = 0; j < this.dimensions; j++) {
                pos[margin + j] = tempPos[j];
            }
        }
        return pos;
    }

    @Override
    public int getDimensions() {
        return this.dimensions;
    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
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
        this.numVertices = Constants.THREE;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Shape newInstance() {
        return new Shape2(Constants.THREE, Constants.THREE);
    }

    @Override
    public void transferFrom(Shape s) {
        this.dimensions = s.getDimensions();
        this.numVertices = s.getNumVertices();
        this.points = s.getPoints();
        s.clear();
    }

}
