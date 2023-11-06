package lotto.domain;

import lotto.constant.LottoConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static lotto.constant.ErrorMessage.*;

public class WinningLotto {
    private final List<Integer> winnerNumber;

    public WinningLotto(String inputWinnerNumber) {
        List<Integer> winningNumbers = parseToInteger(removeBySpace(inputWinnerNumber));
        validate(winningNumbers);
        this.winnerNumber = winningNumbers;
    }

    public List<Integer> getWinnerNumber() {
        return this.winnerNumber;
    }

    private void validate(List<Integer> winnerNumber) {
        validateSize(winnerNumber);
        validateRange(winnerNumber);
        validateDuplicate(winnerNumber);
    }

    private void validateSize(List<Integer> winnerNumber) {
        if (winnerNumber.size() != LottoConfig.LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE.toString());
        }
    }

    private void validateRange(List<Integer> winnerNumber) {
        for (Integer number : winnerNumber) {
            if (number < LottoConfig.MIN_RANGE || number > LottoConfig.MAX_RANGE) {
                throw new IllegalArgumentException(ERROR_LOTTO_RANGE.toString());
            }
        }
    }

    private void validateDuplicate(List<Integer> winnerNumber) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winnerNumber);
        if (nonDuplicateNumbers.size() != winnerNumber.size()) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE.toString());
        }
    }

    private String[] splitComma(String inputWinnerNumbers){
        return inputWinnerNumbers.split(",");
    }

    public void validateNumber(String[] winnerNumber){
        for (String number : winnerNumber) {
            if (!isNumeric(number)) {
                throw new IllegalArgumentException(ERROR_NOT_NUMBER.toString());
            }
        }
    }

    private boolean isNumeric(String str) {
        return str.matches(LottoConfig.IS_NUMBER);
    }

    private List<Integer> parseToInteger(String winnerNumbers) {
        String[] winnerNumber = splitComma(winnerNumbers);
        validateNumber(winnerNumber);
        return Stream.of(winnerNumber)
                .map(Integer::parseInt)
                .toList();
    }

    private String removeBySpace(String inputWinnerNumbers) {
        return inputWinnerNumbers.replaceAll("\\s*,\\s*", ",");
    }
}
