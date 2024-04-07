import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;;

/**
 * Simple HelloWorld program (clear of Checkstyle and SpotBugs warnings).
 *
 * @author P. Bucci
 */
public final class TestObjects4D {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private TestObjects4D() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        int[] pointCoords0 = { 0, 20, 10 };
        int[] pointCoords10 = { 10, 40, -10 };
        Point p = new Point2();
        p.createPointFrame(pointCoords0, 0);
        p.createPointFrame(pointCoords10, 10);
        int[] pointCoords4 = p.getPointCoordinates(4);
        out.print("PointCoords4: ");
        for (int i = 0; i < pointCoords4.length; i++) {
            out.print(pointCoords4[i]);
            if (i != pointCoords4.length - 1) {
                out.print(",");
            } else {
                out.println();
                out.println();
            }
        }

        int[] lineCoords0 = { 0, 10, 10, -40, -10, -100 };
        int[] lineCoords10 = { 100, 210, -40, 0, 70, -150 };
        Line l = new Line2();
        l.createLineFrame(lineCoords0, 0);
        l.createLineFrame(lineCoords10, 10);

        int[] objectCoords0 = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] objectCoords10 = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        Object o = new Object2();
        o.createObjectFrame(objectCoords0, 0, 3);
        o.createObjectFrame(lineCoords10, 10, 3);

        out.close();
    }

}
