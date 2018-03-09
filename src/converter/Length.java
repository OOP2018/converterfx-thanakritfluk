package converter;

/**
 * Class with a fixed set of static instances (defined inside the enum).
 * We use an enum for Length units
 * @author Thanakrit Daorueang
 */

public enum Length {
    Mile(1609.344),
    Kilometer(1000.0),
    Meter(1.0),
    Centimeter(0.0100),
    Foot(0.30480),
    Wa(2.00000),
    Au(149597870700.0);

    private final double value;

    /**
     * This use to set the this value.
     * @param value is the value that input.
     */
    private Length(double value) {
        this.value = value;
    }

    /**
     * This use to get the value of each unit length.
     * @return the value of unit length.
     */
    public double getValue(){
        return this.value;
    }


}
