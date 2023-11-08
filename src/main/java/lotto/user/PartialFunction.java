package lotto.user;

import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class PartialFunction {
    private static final Validation validation = new Validation();

    public int getMoneyNumber(String purchaseMoney) {
        validation.checkNull(purchaseMoney);

        int moneyNumber;
        try {
            moneyNumber = convertStringToInteger(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 형식으로 입력해야 합니다.");
        }
        validation.checkUnit(moneyNumber);
        return moneyNumber;
    }

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

    public int getBonusNumber(String bonusLotto, List<Integer> winningNumbers) {
        validation.checkNull(bonusLotto);
        try {
            int bonusNumber = convertStringToInteger(bonusLotto);
            validateNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해야 합니다.");
        }
    }

    private void validateNumber(int bonusNumber, List<Integer> winningNumbers) {
        validation.checkRange(bonusNumber, 1, 45);
        List<Integer> totalWinningLotto = new ArrayList<>(winningNumbers);
        totalWinningLotto.add(bonusNumber);
        validation.checkDuplication(totalWinningLotto);
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
