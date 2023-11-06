package lotto;

public class Util {

    public static Integer checkNumberValidate(String line) {
        try {
            return Integer.parseInt(line);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public static Integer checkTotalPrice(Integer price) {
        if(price % 1000 != 0) throw new IllegalArgumentException();
        return price / 1000;
    }
}
