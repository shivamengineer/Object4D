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
