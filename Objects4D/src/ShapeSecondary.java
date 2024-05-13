/**
 *
 * @author Shivam Engineer
 *
 */
public abstract class ShapeSecondary implements Shape {

    /**
     *
     */
    @Override
    public void translateFrame(int time, Integer[] translateDistance) {
        Integer[] distance = this.removeFrame(time).value();
        for (int i = 0; i < distance.length; i++) {
            distance[i] += translateDistance[i];
        }
        this.createNewFrame(time, distance);
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
        return null;
    }

    /**
     *
     */
    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < this.getNumVertices(); i++) {
            toString += "Vertex ";
            toString += i;
            toString += ": ";
            toString += this.getPoints()[i].toString();
            toString += ". ";
        }
        return toString;
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        return this.getDimensions() * this.getNumVertices();
    }

    /**
     *
     */
    @Override
    public boolean equals(java.lang.Object o) {
        return this.hashCode() == o.hashCode();
    }
}
