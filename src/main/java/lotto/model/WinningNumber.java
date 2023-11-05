package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.message.Error;

public class WinningNumber {

    private List<Integer> winningNumbers;

    private WinningNumber(String winningNumbers) {
        List<String> seperatedNumbers = split(winningNumbers);
        checkOversize(seperatedNumbers);
        List<Integer> candidateWinningNumbers = toInteger(seperatedNumbers);
        checkOutOfBound(candidateWinningNumbers);
        checkDuplicate(candidateWinningNumbers);
        this.winningNumbers = candidateWinningNumbers;
    }

    public static WinningNumber create(String winningNumbers) {
        return new WinningNumber(winningNumbers);
    }

    private List<String> split(String winningNumbers) {
        return List.of(winningNumbers.split(","));
    }

    private void checkOversize(List<String> seperatedNumbers) {
        if (seperatedNumbers.size() != Lotto.NUMBER_COUNT) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_OVERSIZE.getMessage());
        }
    }

    private List<Integer> toInteger(List<String> seperatedNumbers) {
        try {
            return seperatedNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private void checkOutOfBound(List<Integer> candidateWinningNumbers) {
        candidateWinningNumbers.forEach(this::checkInrange);
    }

    private void checkInrange(Integer lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || lottoNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_OUT_OF_BOUND.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> candidateWinningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(candidateWinningNumbers);
        if (candidateWinningNumbers.size() != uniqueWinningNumbers.size()) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_DUPLICATED.getMessage());
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
