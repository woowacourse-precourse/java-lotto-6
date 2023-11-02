package lotto;

public class Validation {

    public static void isValidUnit(int number, int unit) {
        if (number == 0 || number % unit != 0) {
            throw new IllegalArgumentException("[ERROR]: " + unit + "단위로 입력해야 합니다.");
        }
    }

    public static void isNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]: 숫자를 입력해야 합니다.");
        }
    }
}