package lotto.valid;

import java.util.List;

public class Validator {

    protected static int convertToInteger(String number) throws IllegalArgumentException {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    protected static List<Integer> convertToInteger(List<String> numbers) throws IllegalArgumentException {
        return numbers.stream()
                .map(Validator::convertToInteger)
                .toList();
    }

    protected static void validateLottoRange(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력해주세요.");
        }
    }

    protected static void validateLottoRange(List<Integer> numbers) throws IllegalArgumentException {
        numbers.forEach(Validator::validateLottoRange);
    }

    protected static void validatePositive(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 숫자를 입력해주세요.");
        }
    }

}
