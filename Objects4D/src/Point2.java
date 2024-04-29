import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 *
 * @author Shivam Engineer
 *
 */
public final class Point2 extends PointSecondary {

    /**
     *
     */
    private Sequence<Integer> times;

    /**
     *
     */
    private Map<Integer, int[]> positions;

    /**
     *
     */
    private int dimensions;

    /**
     * @param d
     */
    public void point2(int d) {
        this.times = new Sequence1L<Integer>();
        this.positions = new Map1L<Integer, int[]>();
        this.dimensions = d;
    }

    /**
     *
     */
    @Override
    public int findTimeIndex(int time) {
        boolean posFound = false;
        int index = this.times.length();
        for (int i = 0; i < this.times.length() && !posFound; i++) {
            if (time < this.times.entry(i)) {
                posFound = true;
                index = i - 1;
            }
        }
        return index;
    }

    /**
     * @requires point.length == length of this.positions.removeAny.value()
     */
    @Override
    public void createPointFrame(int[] point, int time) {
        if (this.positions.size() == 0) {
            this.dimensions = point.length;
        }
        if (!this.positions.hasKey(time)) {
            this.times.add(this.findTimeIndex(time), time);
            this.positions.add(time, point);
        } else {
            this.positions.remove(this.findTimeIndex(time));
            this.positions.add(time, point);
        }
    }

    /**
     *
     */
    @Override
    public Map.Pair<Integer, int[]> removePointFrame(int time) {
        assert this.positions.hasKey(time) : "violation of time frame exists";
        return this.positions.remove(time);
    }

    /**
     *
     */
    private void createNewRep() {
        this.times.clear();
        this.positions.clear();
        this.dimensions = Constants.THREE;
        int[] point = new int[this.dimensions];
        for (int i = 0; i < point.length; i++) {
            point[i] = 0;
        }
        this.createPointFrame(point, 0);
    }

    /**
     *
     */
    @Override
    public int[] getPointCoordinates(int time) {
        int[] pointCoords = new int[this.dimensions];
        if (this.positions.hasKey(time)) {
            pointCoords = this.positions.value(time);
        } else {
            int index = this.findTimeIndex(time);
            if (index == this.times.length() - 1) {
                pointCoords = this.positions.value(this.times.entry(index));
            } else {
                int[] previousCoords = this.positions
                        .value(this.times.entry(index));
                int[] nextCoords = this.positions
                        .value(this.times.entry(index + 1));
                int time1 = this.times.entry(index);
                int time2 = this.times.entry(index + 1);

                int timeDifference = time2 - time1;

                for (int i = 0; i < this.dimensions; i++) {
                    pointCoords[i] = previousCoords[i];

                    int posDifference = nextCoords[i] - previousCoords[i];
                    int slope = posDifference / timeDifference;
                    pointCoords[i] += slope * (time - time1);
                }
            }
        }
        return pointCoords;
    }

    @Override
    public Sequence<Integer> getOrderedTimes() {
        return this.times;
    }

    @Override
    public Map<Integer, int[]> getPositionFrames() {
        return this.positions;
    }

    @Override
    public int getDimensions() {
        return this.dimensions;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Point newInstance() {
        return new Point2();
    }

    @Override
    public void transferFrom(Point p) {
        Map<Integer, int[]> temp = this.positions;
        Sequence<Integer> tempSeq = this.times;
        this.positions = p.getPositionFrames();
        this.times = p.getOrderedTimes();
        p.clear();
    }

}
