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
