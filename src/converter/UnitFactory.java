package converter;

/**
 * This use to set the factory of unit.
 * @author Thanakrit Daorueang.
 */
public class UnitFactory {

    private static UnitFactory nowInstant;

    /**
     * This use to get instance of factory.
     * @return the unit factory.
     */
    public static UnitFactory getInstance(){
        if (nowInstant == null) nowInstant = new UnitFactory();
        return nowInstant;
    }

    /**
     * @return the array value of unit.
     */
    public UnitType[] getUnitsTypes(){
        return UnitType.values();
    }

    /**
     *
     * @param unitType the unit.
     * @return the array of value.
     */
    public Unit[] getUnits(UnitType unitType){
        switch (unitType){
            case Length: return Length.values();
            case Weight: return Weight.values();
            case Temperature: return Temperature.values();
            case Area: return Area.values();
            default:return null;
        }
    }
}
