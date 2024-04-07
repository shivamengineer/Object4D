import components.map.Map;
import components.sequence.Sequence;

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
    public void translatePointAtTime(int[] translateDistance, int time) {
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
        this.createPointFrame(newPosition, time);
    }

    /**
     *
     */
    @Override
    public void setNewPointCoordinates(int[] newCoordPosition, int time) {
        assert newCoordPosition.length == this
                .getDimensions() : "violation of wrong "
                        + "number of dimensions";
        this.createPointFrame(newCoordPosition, time);
    }

    /**
     *
     */
    @Override
    public Map.Pair<Integer, int[]> previousPositionFrame(int time) {
        Map<Integer, int[]> tempPositions = this.getPositionFrames();
        return tempPositions.remove(this.findTimeIndex(time) - 1);
    }

    /**
     *
     */
    @Override
    public Map.Pair<Integer, int[]> nextPositionFrame(int time) {
        Map<Integer, int[]> tempPositions = this.getPositionFrames();
        return tempPositions.remove(this.findTimeIndex(time) + 1);
    }

    /**
     *
     */
    @Override
    public String toString() {
        String toString = "";
        Sequence<Integer> times = this.getOrderedTimes();
        Map<Integer, int[]> positions = this.getPositionFrames();
        for (int i = 0; i < times.length(); i++) {
            Map.Pair<Integer, int[]> tempPos = positions.remove(times.entry(i));
            toString += "Time ";
            toString += times.entry(i);
            toString += ": ";
            for (int j = 0; j < this.getDimensions(); j++) {
                toString += tempPos.value()[j];
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
