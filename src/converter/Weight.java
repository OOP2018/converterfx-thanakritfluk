package converter;

public enum Weight implements Unit<Weight>{

    Gram(0.001),
    Kilogram(1),
    Pound(0.45),
    Milligram(1e-6),
    Tonne(1000),
    Chang(1.2)
    ;

    private final double value;

    /**
     * This use to change the weight to diffent unit weight.
     * @param amount value to covert.
     * @param toUnit the unit use to change to.
     * @return the value the has been converted.
     */
    @Override
    public double convert(double amount, Weight toUnit) {
        return this.getValue() * amount/toUnit.getValue() ;
    }

    /**
     * This use to set the value.
     * @param v the value that input.
     */
    Weight(double v) {
        this.value = v;
    }

    /**
     *
     * @return the value of unit.
     */
    public double getValue() {
        return this.value;
    }
}
