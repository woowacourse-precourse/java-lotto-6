package lotto.exception;

import java.util.List;

public class InputNumberException {
    private InputNumberException() {
    }

    public static void inputValidate(List<String> numbers) {
        notNumberValidate(numbers);
    }

    private static void notNumberValidate(List<String> numbers) {
        numbers.forEach((String number) -> {
                    try {
                        Integer.parseInt(number);
                    } catch (NumberFormatException exception) {
                        throw new IllegalArgumentException();
                    }
                });
    }
}
