package converter;

/**
 * This is the temperature kind of enum.
 * @author Thanakrit Daorueang.
 */

public enum Temperature implements Unit<Temperature> {

    Fahrenheit(-17.22),
    Celcius(1),
    Kelvin(273),
    Rankine(2),;

    private final double value;

    /**
     * This use to change the temperature to diffent unit temperature.
     * @param amount value to covert.
     * @param toUnit the unit use to change to.
     * @return the value the has been converted.
     */
    @Override
    public double convert(double amount, Temperature toUnit) {
        if (this.equals(Celcius)) {
            if (toUnit.equals(Fahrenheit)) return (1.8 * amount) + 32;
            if (toUnit.equals(Kelvin)) return amount + 273;
            if (toUnit.equals(Celcius)) return amount;
            else return amount * 0.8;
        }
        if (this.equals(Fahrenheit)) {
            if (toUnit.equals(Celcius)) return 5*((amount - 32)/9);
            if (toUnit.equals(Kelvin)) return (amount + 459.67) / 1.8;
            if (toUnit.equals(Fahrenheit)) return amount;
            else return ((amount - 32) / 9) * 4;
        }
        if (this.equals(Rankine)) {
            if (toUnit.equals(Celcius)) return amount * 1.25;
            if (toUnit.equals(Kelvin)) return ((amount / 4) * 5) + 273;
            if (toUnit.equals(Rankine)) return amount;
            else return (amount * (9 / 4)) + 32;
        }
        if (this.equals(Kelvin)) {
            if (toUnit.equals(Celcius)) return amount - 273;
            if (toUnit.equals(Fahrenheit)) return (((amount - 273) / 5) * 9) + 32;
            if (toUnit.equals(Kelvin)) return amount;
            else return ((amount - 273) / 5) * 4;
        }
        return 0;
    }

    /**
     * This use to set the value.
     * @param value the value that input.
     */
    Temperature(double value) {
        this.value = value;
    }

    /**
     * This use to get the value of each unit.
     * @return the value of each unit.
     */
    public double getValue() {
        return this.value;
    }


}
