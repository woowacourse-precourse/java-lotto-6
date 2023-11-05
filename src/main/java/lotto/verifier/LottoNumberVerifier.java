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

}
