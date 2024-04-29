import components.map.Map;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 *
 * @author Shivam Engineer
 *
 */
public abstract class PointSecondary implements Point {

    /**
     *
     */
    @Override
    public void translatePointAtTime(int time, int[] translateDistance) {
        assert translateDistance.length == this
                .getDimensions() : "violation of wrong "
                        + "number of dimensions";
        assert this.getPositionFrames()
                .hasKey(time) : "violation of time frame exists";

        int[] newPosition = new int[this.getDimensions()];
        for (int i = 0; i < newPosition.length; i++) {
            newPosition[i] = this.getPointCoordinates(time)[i]
                    + translateDistance[i];
        }
        this.createPointFrame(time, newPosition);
    }

    /**
     *
     */
    @Override
    public void setNewPointCoordinates(int time, int[] newCoordPosition) {
        assert newCoordPosition.length == this
                .getDimensions() : "violation of wrong "
                        + "number of dimensions";
        this.createPointFrame(time, newCoordPosition);
    }

    /**
     *
     */
    @Override
    public Map.Pair<Integer, Sequence1L<Integer>> previousPositionFrame(
            int time) {
        Map<Integer, Sequence1L<Integer>> tempPositions = this
                .getPositionFrames();
        return tempPositions.remove(this.findTimeIndex(time) - 1);
    }

    /**
     *
     */
    @Override
    public Map.Pair<Integer, Sequence1L<Integer>> nextPositionFrame(int time) {
        Map<Integer, Sequence1L<Integer>> tempPositions = this
                .getPositionFrames();
        return tempPositions.remove(this.findTimeIndex(time) + 1);
    }

    /**
     *
     */
    @Override
    public String toString() {
        String toString = "";
        Sequence<Integer> times = this.getOrderedTimes();
        Map<Integer, Sequence1L<Integer>> positions = this.getPositionFrames();
        for (int i = 0; i < times.length(); i++) {
            Map.Pair<Integer, Sequence1L<Integer>> tempPos = positions
                    .remove(times.entry(i));
            toString += "Time ";
            toString += times.entry(i);
            toString += ": ";
            for (int j = 0; j < this.getDimensions(); j++) {
                toString += tempPos.value().entry(j);
                if (j != this.getDimensions() - 1) {
                    toString += ",";
                }
            }
            toString += ". ";
        }
        return toString;
    }

    /**
     *
     */
    @Override
    public boolean equals(Point p) {
        boolean equal = true;
        if (!this.getOrderedTimes().equals(p.getOrderedTimes())) {
            equal = false;
        } else if (!this.getPositionFrames().equals(p.getPositionFrames())) {
            equal = false;
        }
        return equal;
    }
}
