package converter;

/**
 * This use to check all of length unit.
 * @author Thanakrit Daorueang
 */
public class Test {

    public static void main(String[] args) {
        Length[] lengths = Length.values();
        for (Length x : lengths) {
            System.out.println(x.toString() + " = " + x.getValue());
        }
    }
}
