package lotto.valid;

public class Validator {

    protected static int isNumeric(String number) throws IllegalArgumentException {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    protected static void isPositive(int number) throws IllegalArgumentException {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 큰 숫자를 입력해주세요.");
        }
    }

}
