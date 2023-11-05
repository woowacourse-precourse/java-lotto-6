package lotto.verifier;

import lotto.exception.ExceptionMsg;

public class LottoNumberVerifier {
    private final String winningNumbers;

    public LottoNumberVerifier(String winningNumbers) {
        this.winningNumbers = winningNumbers;
    }


    private int verifyParseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMsg.NOT_INT_INPUT.getMessage());
        }
    }
    private void verifyNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 값이어야 합니다: " + number);
        }
    }
}
