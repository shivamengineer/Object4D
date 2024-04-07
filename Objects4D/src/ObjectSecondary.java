import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;

/**
 *
 * @author shivam
 *
 */
public abstract class ObjectSecondary implements Object {

    /**
     *
     * @param translateDistance
     * @param time
     */
    @Override
    public void translateObjectAtTime(int[] translateDistance, int time) {
        assert translateDistance.length == Constants.DIMENSIONS : "violation of "
                + "correct number of dimensions to translate";
        for (int i = 0; i < this.getNumVertices(); i++) {
            this.getLines()[i].translateLineAtTime(translateDistance, time);
        }
    }

    /**
     *
     * @param pointCoords
     */
    @Override
    public void setNewObjectCoordinates(int[] pointCoords, int time) {
        assert pointCoords.length == Constants.DIMENSIONS : "violation of "
                + "correct number of dimensions to translate";
        boolean init = false;
        int[] last = new int[Constants.DIMENSIONS];
        int lines = 0;
        for (int i = 0; i < this.getNumVertices(); i++) {
            this.getLines()[i] = new Line2();
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
            this.getLines()[i].setNewLineCoordinates(lineCoords, time);
        }
    }

    /**
     *
     */
    @Override
    public Pair<Integer, int[]> previousPositionFrame(int time) {
        Line[] lines = this.getLines();
        int[][] positions = new int[lines.length][Constants.DIMENSIONS * 2];
        for (int i = 0; i < lines.length; i++) {
            Map<Integer, int[]> tempPositions1 = lines[i].getPoint1()
                    .getPositionFrames();
            Map<Integer, int[]> tempPositions2 = lines[i].getPoint2()
                    .getPositionFrames();
            Map.Pair<Integer, int[]> tempPair1 = tempPositions1
                    .remove(lines[i].getPoint1().findTimeIndex(time) - 1);
            Map.Pair<Integer, int[]> tempPair2 = tempPositions2
                    .remove(lines[i].getPoint2().findTimeIndex(time) - 1);
            int[] value = new int[Constants.DIMENSIONS * 2];
            for (int j = 0; j < Constants.DIMENSIONS; j++) {
                value[i] = tempPair1.value()[i];
                positions[i][j] = tempPair1.value()[i];
            }
            for (int j = Constants.DIMENSIONS; j < Constants.DIMENSIONS
                    * 2; j++) {
                value[i] = tempPair2.value()[i - Constants.DIMENSIONS];
                positions[i][j] = tempPair2.value()[i - Constants.DIMENSIONS];
            }
        }
        int[] allPositions = new int[lines.length * Constants.DIMENSIONS];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < Constants.DIMENSIONS; j++) {
                allPositions[(i * Constants.DIMENSIONS) + j] = positions[i][j];
            }
        }
        Map<Integer, int[]> tempPosition = new Map1L<Integer, int[]>();
        tempPosition.add(time, allPositions);
        Map.Pair<Integer, int[]> pair = tempPosition.remove(time);
        return pair;
    }

    /**
     *
     */
    @Override
    public Pair<Integer, int[]> nextPositionFrame(int time) {
        Line[] lines = this.getLines();
        int[][] positions = new int[lines.length][Constants.DIMENSIONS * 2];
        for (int i = 0; i < lines.length; i++) {
            Map<Integer, int[]> tempPositions1 = lines[i].getPoint1()
                    .getPositionFrames();
            Map<Integer, int[]> tempPositions2 = lines[i].getPoint2()
                    .getPositionFrames();
            Map.Pair<Integer, int[]> tempPair1 = tempPositions1
                    .remove(lines[i].getPoint1().findTimeIndex(time) + 1);
            Map.Pair<Integer, int[]> tempPair2 = tempPositions2
                    .remove(lines[i].getPoint2().findTimeIndex(time) + 1);
            int[] value = new int[Constants.DIMENSIONS * 2];
            for (int j = 0; j < Constants.DIMENSIONS; j++) {
                value[i] = tempPair1.value()[i];
                positions[i][j] = tempPair1.value()[i];
            }
            for (int j = Constants.DIMENSIONS; j < Constants.DIMENSIONS
                    * 2; j++) {
                value[i] = tempPair2.value()[i - Constants.DIMENSIONS];
                positions[i][j] = tempPair2.value()[i - Constants.DIMENSIONS];
            }
        }
        int[] allPositions = new int[lines.length * Constants.DIMENSIONS];
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < Constants.DIMENSIONS; j++) {
                allPositions[(i * Constants.DIMENSIONS) + j] = positions[i][j];
            }
        }
        Map<Integer, int[]> tempPosition = new Map1L<Integer, int[]>();
        tempPosition.add(time, allPositions);
        Map.Pair<Integer, int[]> pair = tempPosition.remove(time);
        return pair;
    }

    /**
     * @param o
     * @return equal
     */
    @Override
    public boolean equals(Object o) {
        boolean equal = true;
        Line[] lines = this.getLines();
        Line[] lines2 = o.getLines();
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].equals(lines2[i])) {
                equal = false;
            }
        }
        o.clear();
        return equal;
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        String toString = "";
        Line[] lines = this.getLines();
        for (int i = 0; i < lines.length; i++) {
            toString += "Line";
            toString += i;
            toString += ": ";
            toString += lines[i].toString();
        }
        return toString;
    }

}
