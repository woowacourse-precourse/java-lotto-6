package Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserValidator {

    private static final int MIN_MONEY_RANGE = 1000;
    private static final int MAX_MONEY_RANGE = 1000000000;
    private static final int MONEY_MAX_LENGTH = 10;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private  static final int MAX_LOTTO_NUMBER = 45;

    void validateEmptyInput(String userInput) {
        if (userInput.isEmpty() || userInput.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyLength(String money) {
        if (money.length() > MONEY_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyInRange(int money) {
        if (money >= MIN_MONEY_RANGE && money <= MAX_MONEY_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    void validateMoneyNumeric(String money) {
        for (int moneyIndex = 0; moneyIndex < money.length(); moneyIndex++) {
            if (Character.isDigit(money.charAt(moneyIndex))) {
                throw new IllegalArgumentException();
            }
        }
    }

    void validateWinningNumberLength(List<Integer> winningNumber) {
        if (winningNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    String deleteWhiteSpace(String predictedLottoNumber) {
        return predictedLottoNumber.replace("\\s", "");
    }

    String correctCommas(String predictedLottoNumber) {
        predictedLottoNumber = predictedLottoNumber.replaceAll("^,|,$", "");
        predictedLottoNumber = predictedLottoNumber.replaceAll(",+", ",");
        return predictedLottoNumber;
    }

    void validateWinningNumberRange(List<Integer> winningNumber) {
        for (Integer lottoNumber : winningNumber) {
            if (MIN_LOTTO_NUMBER > lottoNumber || MAX_LOTTO_NUMBER < lottoNumber) {
                throw  new IllegalArgumentException();
            }
        }
    }
}
