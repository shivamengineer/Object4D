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
    public void translateFrame(int time, Integer[] translateDistance) {
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
    public void setFramePosition(int time, Integer[] newCoords) {
        this.removeFrame(time);
        this.createNewFrame(time, newCoords);
    }

    /**
     *
     */
    @Override
    public Integer[] getPositionAtTime(int time) {
        Integer[] position = null;
        Map<Integer, Integer[]> tempMap = this.getFrames();
        if (tempMap.hasKey(time)) {
            position = tempMap.value(time);
        } else if (tempMap.size() > 0) {
            Sequence<Integer> tempSeq = this.getTimes();
            boolean found = false;
            int i;
            for (i = 0; !found && i < tempSeq.length(); i++) {
                if (tempSeq.entry(i) > time) {
                    found = true;
                }
            }
            if (i == 0 || i == tempSeq.length() - 1) {
                position = tempMap.value(tempSeq.entry(i));
            } else {
                Integer[] pos1 = tempMap.value(tempSeq.entry(i));
                Integer[] pos2 = tempMap.value(tempSeq.entry(i + 1));
                for (int j = 0; j < position.length; j++) {
                    position[j] = (pos2[j] - pos1[j])
                            / (tempSeq.entry(i + 1) - tempSeq.entry(i));
                }
            }
        }
        return position;
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
        return this.getTimes().length();
    }

    /**
     *
     */
    @Override
    public boolean equals(java.lang.Object o) {
        return this.hashCode() == o.hashCode();
    }
}
