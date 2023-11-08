package lotto;

public class InputValidationTest {
    public static void isItInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static void isItPositive(String input) {
        int inputAsInteger = Integer.parseInt(input);
        if (inputAsInteger <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    public static void isItThousands(String input) {
        int inputAsInteger = Integer.parseInt(input);
        if (inputAsInteger % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수를 입력해주세요.");
        }
    }
}
