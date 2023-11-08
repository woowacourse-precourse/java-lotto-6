package lotto.user;

import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class Winning {
    private static final Validation validation = new Validation();

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
        validation.checkCount(winnerNumbers.size(), 6);
        for (int number : winnerNumbers) {
            validation.checkRange(number, 1, 45);
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
