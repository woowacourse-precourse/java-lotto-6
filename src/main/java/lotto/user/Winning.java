package lotto.user;

import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private static final Validation validation = new Validation();
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;

    public List<Integer> getWinningNumbers(String winningLotto) {
        validation.checkNull(winningLotto);
        try {
            List<Integer> winnerNumbers = new ArrayList<>(
                    convertStringToIntegerList(winningLotto)
            );
            validateNumbers(winnerNumbers);
            return winnerNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해야 합니다.");
        }
    }

    private static void validateNumbers(List<Integer> winnerNumbers) {
        validation.checkCount(winnerNumbers.size(), LOTTO_COUNT);
        for (int number : winnerNumbers) {
            validation.checkRange(number, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX);
        }
        validation.checkDuplication(winnerNumbers);
    }

    private static List<Integer> convertStringToIntegerList(String input) {
        List<Integer> resultNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(",");

        for (String inputNumber : inputNumbers) {
            inputNumber = inputNumber.trim();
            if (inputNumber.equals(""))
                continue;

            int number = convertStringToInteger(inputNumber);
            resultNumbers.add(number);
        }
        return resultNumbers;
    }

    private static Integer convertStringToInteger(String number) {
        number = number.trim();
        return Integer.parseInt(number);
    }
}
