package lotto.verifier;

import lotto.exception.ExceptionMsg;

import java.util.HashSet;
import java.util.Set;

public class LottoNumberVerifier {
    private final String winningNumbers;

    public LottoNumberVerifier(String winningNumbers) {
        this.winningNumbers = winningNumbers;
        validateWinningNumbers();
    }

    private void validateWinningNumbers() {
        if (winningNumbers == null || winningNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMsg.NULL_INPUT.getMessage());
        }

        String[] splitNumbers = winningNumbers.split(",");
        //중복 여부 처리를 위해 HashSet 사용
        Set<Integer> numberSet = new HashSet<>();

        for (String numberStr : splitNumbers) {
            int number = verifyParseNumber(numberStr);
            verifyNumberRange(number);
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException(ExceptionMsg.DUPLICATE_LOTTO_NUM.getMessage());
            }
        }
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
