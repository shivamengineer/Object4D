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
    public void translateFrame(Integer time, Integer[] translateDistance) {
        Map.Pair<Integer, Integer[]> temp = this.removeFrame(time);
        Integer[] pos = temp.value();
        for (int i = 0; i < pos.length; i++) {
            pos[i] += translateDistance[i];
        }
        this.createNewFrame(time, pos);
    }

    /**
     *
     */
    @Override
    public void setFramePosition(Integer time, Integer[] newCoords) {
        this.removeFrame(time);
        this.createNewFrame(time, newCoords);
    }

    /**
     *
     */
    @Override
    public String toString() {
        String toString = "";
        Sequence<Integer> times = this.getTimes();
        Map<Integer, Integer[]> keyFrames = this.getFrames();
        for (int i = 0; i < times.length(); i++) {
            Integer time = times.entry(i);
            Integer[] position = keyFrames.value(time);
            toString += "Time " + time + ": {";
            for (int j = 0; j < position.length - 1; j++) {
                toString += position[j] + ", ";
            }
            toString += position[position.length - 1] + "}. ";
        }
        return toString;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return 0;
    }

    /**
     *
     */
    @Override
    public boolean equals(Object o) {
        return false;
    }
}
