package converter;

/**
 * This use to manage the unit that have diffent logic of convert.
 * @param <T> the type of unit.
 * @author Thanakrit Daorueang.
 */
public interface Unit<T> {
    /**
     * This use to convert between 2 diffent type of unit.
     * @param amount the value use to convert.
     * @param toUnit the unit that want to change to.
     * @return the value of coverted.
     */
    double convert(double amount,T toUnit);

    /**
     *
     * @return the value of unit.
     */
    double getValue();

    String toString();
}

