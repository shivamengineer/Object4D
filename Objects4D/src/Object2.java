/**
 *
 * @author Shivam Engineer
 *
 */
public final class Object2 extends ObjectSecondary {

    /**
     *
     */
    private int numVertices;

    /**
     * change to points
     */
    private Line2[] lines;
    //private Point2[] points;

    /**
     *
     */
    private int dimensions;

    /**
     * adjust to use points instead
     */
    public Object2() {
        this.dimensions = Constants.DIMENSIONS;
        this.numVertices = Constants.DIMENSIONS;
        this.lines = new Line2[this.numVertices];
        //this.points = new Point2[this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            this.lines[i] = new Line2();
            //this.points[i] = new Point2();
        }
    }

    @Override
    public void createObjectFrame(int[] pointCoords, int time,
            int numVertices) {
        assert this.numVertices >= 2 : "violation of numVertices greater than 2";
        assert pointCoords.length == Constants.DIMENSIONS
                * this.numVertices : "violation of enough point coordinates";

        //set dimensions
        //replace lines with points
        boolean init = false;
        int[] last = new int[Constants.DIMENSIONS];
        int lines = 0;
        for (int i = 0; i < this.numVertices; i++) {
            this.lines[i] = new Line2();
            int[] temp = new int[Constants.DIMENSIONS];
            if (!init) {
                init = true;
                for (int j = 0; j < Constants.DIMENSIONS; j++) {
                    last[j] = pointCoords[j];
                }
                lines++;
            } else {
                for (int j = 0; j < Constants.DIMENSIONS; j++) {
                    temp[j] = pointCoords[(i * lines) + j];
                }
            }
            lines++;
            int[] lineCoords = new int[Constants.DIMENSIONS * 2];
            for (int j = 0; j < Constants.DIMENSIONS; j++) {
                lineCoords[j] = last[j];
            }
            for (int j = Constants.DIMENSIONS; j < Constants.DIMENSIONS
                    * 2; j++) {
                lineCoords[j] = last[j - Constants.DIMENSIONS];
            }
            this.lines[i].createLineFrame(lineCoords, time);
        }
        int[] endLineCoords = new int[Constants.DIMENSIONS * 2];
        for (int i = 0; i < Constants.DIMENSIONS; i++) {
            endLineCoords[i] = pointCoords[pointCoords.length
                    - (Constants.DIMENSIONS) + i];
        }
        for (int i = 0; i < Constants.DIMENSIONS; i++) {
            endLineCoords[i + Constants.DIMENSIONS] = pointCoords[i];
        }
        this.lines[this.lines.length - 1] = new Line2();
        this.lines[this.lines.length - 1].createLineFrame(endLineCoords, time);
    }

    @Override
    public void clear() {
        this.numVertices = Constants.DIMENSIONS;
        for (int i = 0; i < this.numVertices; i++) {
            //this.points[i].clear();
            this.lines[i].clear();
        }
    }

    @Override
    public Object newInstance() {
        return new Object2();
    }

    @Override
    public void transferFrom(Object source) {
        // TODO transferFrom
        //this.createObject(source.getObjectCoordinates());
        source.clear();
    }

    @Override
    public int[] getObjectCoordinates(int time) {
        int[] coords = new int[Constants.DIMENSIONS * this.numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < Constants.DIMENSIONS; j++) {
                int[] temp = this.lines[i].getLineCoordinates(time);
                coords[(i * Constants.DIMENSIONS) + j] = temp[j];
            }
        }
        return coords;
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
    //public Point[] getPoints(){
    public Line[] getLines() {
        return this.lines;
    }

}
