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
    private Map<Integer, Integer[]> keyFrames;

    /**
     *
     */
    private int dimensions;

    /**
     * @param d
     */
    public Point2(int d) {
        this.times = new Sequence1L<Integer>();
        this.keyFrames = new Map1L<Integer, Integer[]>();
        this.dimensions = d;
    }

    /**
     *
     * @param time
     * @return index
     */
    private int getIndexOfTime(int time) {
        int index = -1;
        boolean indexFound = false;
        for (int i = 0; !indexFound && i < this.times.length(); i++) {
            if (this.times.entry(i) == time) {
                index = i;
                indexFound = true;
            }
        }
        return index;
    }

    @Override
    public void createNewFrame(int time, Integer[] pos) {
        int i = 0;
        boolean addedTime = false;
        do {
            if (i == this.times.length() || time < this.times.entry(i)) {
                this.times.add(i, time);
                addedTime = true;
            }
            i++;
        } while (!addedTime);
        this.keyFrames.add(time, pos);
    }

    @Override
    public Map.Pair<Integer, Integer[]> removeFrame(int time) {
        boolean removed = false;
        for (int i = 0; !removed && i < this.times.length(); i++) {
            if (this.times.entry(i) == time) {
                this.times.remove(i);
                removed = true;
            }
        }
        return this.keyFrames.remove(time);
    }

    @Override
    public Integer[] getPosition(int time) {
        Integer[] pos = null;
        if (this.keyFrames.hasKey(time)) {
            pos = this.keyFrames.remove(time).value();
            int index = this.getIndexOfTime(time);
            this.times.remove(index);
        }
        return pos;
    }

    @Override
    public Sequence<Integer> getTimes() {
        return this.times;
    }

    @Override
    public Map<Integer, Integer[]> getFrames() {
        return this.keyFrames;
    }

    @Override
    public int getDimensions() {
        return this.dimensions;
    }

    /**
     *
     */
    private void createNewRep() {
        this.times.clear();
        this.keyFrames.clear();
        this.dimensions = Constants.THREE;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public Point newInstance() {
        return new Point2(this.dimensions);
    }

    @Override
    public void transferFrom(Point p) {
        this.dimensions = p.getDimensions();
        this.keyFrames = p.getFrames();
        this.times = p.getTimes();
        p.clear();
    }

}
