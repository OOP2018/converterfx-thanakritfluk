package converter;

/**
 * This the enum include the diffent type of area.
 * @author Thanakrit Daorueang.
 */
public enum Area implements Unit<Area> {
    SQ_Meter(1),
    SQ_KiloMeter(1e+6),
    SQ_Foot(0.09290304),
    SQ_Mile(2589988.11),
    Acre(4046.85642),
    SQ_Wa(4);

    private final double value;

    /**
     * This use to set the value.
     * @param value the value that input.
     */
    Area(double value) {
        this.value = value;
    }

    /**
     * This use to change the area to diffent unit area.
     * @param amount value to covert.
     * @param toUnit the unit use to change to.
     * @return the value the has been converted.
     */
    @Override
    public double convert(double amount, Area toUnit) {
        return this.getValue() * amount / toUnit.getValue();
    }

    /**
     * This use to get the value of unit.
     * @return the value of unit.
     */
    @Override
    public double getValue() {
        return 0;
    }
}
