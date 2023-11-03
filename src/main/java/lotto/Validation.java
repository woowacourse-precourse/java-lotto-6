package lotto;

public class Validation {

    public static void isInRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException("[ERROR]: " + min + " ~ " + max + " 범위의 숫자만 가능합니다.");
        }
    }

    public static void isValidUnit(int number, int unit) {
        if (number == 0 || number % unit != 0) {
            throw new IllegalArgumentException("[ERROR]: " + unit + "단위로 입력해야 합니다.");
        }
    }

    public static void isNumber(String string) {
        try {
            for (String split : string.split(",", -1)) {
                Integer.parseInt(split);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해야 합니다.");
        }
    }
}