import components.map.Map;

/**
 *
 * @author Shivam Engineer
 *
 */
public abstract class LineSecondary implements Line {

    /**
     *
     * @param dimensions
     * @param time
     */
    @Override
    public void translateLineAtTime(int[] dimensions, int time) {
        int[] point1Coords = this.getPoint1().getPointCoordinates(time);
        int[] point2Coords = this.getPoint2().getPointCoordinates(time);
        int[] pointNewCoords = new int[this.getDimensions()];

        for (int i = 0; i < this.getDimensions(); i++) {
            pointNewCoords[i] = point1Coords[i] + dimensions[i];
        }
        for (int i = this.getDimensions(); i < this.getDimensions() * 2; i++) {
            pointNewCoords[i] = point2Coords[i - this.getDimensions()]
                    + dimensions[i];
        }
        this.createLineFrame(pointNewCoords, time);
    }

    /**
     *
     * @param dimensions
     * @param time
     */
    @Override
    public void setNewLineCoordinates(int[] dimensions, int time) {
        this.createLineFrame(dimensions, time);
    }

    /**
     *
     * @param time
     * @return previousFrame
     */
    @Override
    public Map.Pair<Integer, int[]> previousPositionFrame(int time) {
        Map<Integer, int[]> tempPositions1 = this.getPoint1()
                .getPositionFrames();
        Map<Integer, int[]> tempPositions2 = this.getPoint2()
                .getPositionFrames();
        Map.Pair<Integer, int[]> tempPair1 = tempPositions1
                .remove(this.getPoint1().findTimeIndex(time) - 1);
        Map.Pair<Integer, int[]> tempPair2 = tempPositions2
                .remove(this.getPoint2().findTimeIndex(time) - 1);
        int[] value = new int[this.getDimensions() * 2];
        for (int i = 0; i < this.getDimensions(); i++) {
            value[i] = tempPair1.value()[i];
        }
        for (int i = this.getDimensions(); i < this.getDimensions() * 2; i++) {
            value[i] = tempPair2.value()[i - this.getDimensions()];
        }
        Map<Integer, int[]> tempPosition = tempPositions1.newInstance();
        tempPosition.add(time, value);
        Map.Pair<Integer, int[]> pair = tempPosition.remove(time);
        return pair;
    }

    /**
     *
     * @param time
     * @return nextFrame
     */
    @Override
    public Map.Pair<Integer, int[]> nextPositionFrame(int time) {
        Map<Integer, int[]> tempPositions1 = this.getPoint1()
                .getPositionFrames();
        Map<Integer, int[]> tempPositions2 = this.getPoint2()
                .getPositionFrames();
        Map.Pair<Integer, int[]> tempPair1 = tempPositions1
                .remove(this.getPoint1().findTimeIndex(time) + 1);
        Map.Pair<Integer, int[]> tempPair2 = tempPositions2
                .remove(this.getPoint2().findTimeIndex(time) + 1);
        int[] value = new int[this.getDimensions() * 2];
        for (int i = 0; i < this.getDimensions(); i++) {
            value[i] = tempPair1.value()[i];
        }
        for (int i = this.getDimensions(); i < this.getDimensions() * 2; i++) {
            value[i] = tempPair2.value()[i - this.getDimensions()];
        }
        Map<Integer, int[]> tempPosition = tempPositions1.newInstance();
        tempPosition.add(time, value);
        Map.Pair<Integer, int[]> pair = tempPosition.remove(time);
        return pair;
    }

    /**
     * @param l
     * @return equal
     */
    @Override
    public boolean equals(Line l) {
        return this.getPoint1().equals(l.getPoint1())
                && this.getPoint2().equals(l.getPoint2());
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        String toString = "";
        toString += "Point1: ";
        toString += this.getPoint1().toString();
        toString += ", ";
        toString += "Point2: ";
        toString += this.getPoint2().toString();
        return toString;
    }

}
