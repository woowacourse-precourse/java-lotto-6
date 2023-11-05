package Model;

import java.util.List;

public class UserValidator {

    private static final int MIN_MONEY_RANGE = 1000;
    private static final int MAX_MONEY_RANGE = 1000000000;
    private static final int MONEY_MAX_LENGTH = 10;
    private static final int LOTTO_NUMBER_SIZE = 6;

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
}
