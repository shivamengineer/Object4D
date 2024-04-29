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
    private Map<Integer, Sequence1L<Integer>> positions;

    /**
     *
     */
    private int dimensions;

    /**
     * @param d
     */
    public Point2(int d) {
        this.times = new Sequence1L<Integer>();
        this.positions = new Map1L<Integer, Sequence1L<Integer>>();
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
                index = i;
            }
        }
        index--;
        return index;
    }

    /**
     *
     * @param arr
     * @return sequence form
     */
    private Sequence1L<Integer> toSequence(int[] arr) {
        Sequence1L<Integer> seq = new Sequence1L<Integer>();
        for (int i = 0; i < arr.length; i++) {
            seq.add(i, arr[i]);
        }
        return seq;
    }

    /**
     *
     * @param seq
     * @return int arr
     */
    private int[] toIntArr(Sequence1L<Integer> seq) {
        int[] arr = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            arr[i] = seq.entry(i);
        }
        return arr;
    }

    /**
     * @requires point.length == length of this.positions.removeAny.value()
     */
    @Override
    public void createPointFrame(int time, int[] point) {
        boolean posFound = false;
        int index = this.times.length();
        for (int i = 0; i < this.times.length() && !posFound; i++) {
            if (time < this.times.entry(i)) {
                posFound = true;
                index = i - 1;
            }
        }
        System.out.println(
                "Time: " + time + ". Seq: " + this.times + ". Index: " + index);
        this.times.add(index, time);
        Sequence1L<Integer> seq = this.toSequence(point);
        this.positions.add(time, seq);
    }

    /**
     *
     */
    @Override
    public Map.Pair<Integer, Sequence1L<Integer>> removePointFrame(int time) {
        assert this.positions.hasKey(time) : "violation of time frame exists";

        this.times.remove(this.findTimeIndex(time));
        return this.positions.remove(time);
    }

    /**
     *
     */
    private void createNewRep() {
        this.times.clear();
        this.positions.clear();
        this.dimensions = Constants.THREE;
    }

    /**
     *
     */
    @Override
    public int[] getPointCoordinates(int time) {
        int[] pointCoords;
        Sequence1L<Integer> seq = new Sequence1L<Integer>();
        System.out.println(this.positions.size());
        if (this.positions.hasKey(time)) {
            System.out.println("true");
            seq = this.positions.value(time);
            System.out.println(this.positions.value(time));
            System.out.println("null");
        } else {
            int index = this.findTimeIndex(time);
            if (index == this.times.length() - 1) {
                System.out.println("true");
                seq = this.positions.value(this.times.entry(index));
            } else {
                System.out.println("false");
                Sequence1L<Integer> previousCoords = this.positions
                        .value(this.times.entry(index));
                Sequence1L<Integer> nextCoords = this.positions
                        .value(this.times.entry(index + 1));
                int time1 = this.times.entry(index);
                int time2 = this.times.entry(index + 1);

                int timeDifference = time2 - time1;
                pointCoords = new int[this.dimensions];
                for (int i = 0; i < this.dimensions; i++) {

                    int posDifference = nextCoords.entry(i)
                            - previousCoords.entry(i);
                    int slope = posDifference / timeDifference;
                    seq.add(i,
                            previousCoords.entry(i) + (slope * (time - time1)));
                }
            }
        }
        pointCoords = this.toIntArr(seq);
        return pointCoords;
    }

    @Override
    public Sequence<Integer> getOrderedTimes() {
        return this.times;
    }

    @Override
    public Map<Integer, Sequence1L<Integer>> getPositionFrames() {
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
        return new Point2(Constants.THREE);
    }

    @Override
    public void transferFrom(Point p) {
        this.positions = p.getPositionFrames();
        this.times = p.getOrderedTimes();
        p.clear();
    }

}
