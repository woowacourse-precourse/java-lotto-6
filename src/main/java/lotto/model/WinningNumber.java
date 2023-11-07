package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.message.Error;

public class WinningNumber {

    private Set<Integer> winningNumbers;

    private WinningNumber(String candidateWinningNumber) {
        List<String> seperatedNumbers = split(candidateWinningNumber);
        checkOversize(seperatedNumbers);
        List<Integer> candidateWinningNumbers = toInteger(seperatedNumbers);
        checkOutOfRange(candidateWinningNumbers);
        this.winningNumbers = checkDuplicate(candidateWinningNumbers);
    }

    public static WinningNumber create(String candidateWinningNumber) {
        return new WinningNumber(candidateWinningNumber);
    }

    public Integer compare(List<Integer> lottoNumbers) {
        Set<Integer> uniqueNumbers = winningNumbers;
        uniqueNumbers.addAll(lottoNumbers);
        return 12 - uniqueNumbers.size();
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

    private void checkOutOfRange(List<Integer> candidateWinningNumbers) {
        candidateWinningNumbers.forEach(this::checkOutOfRange);
    }

    private void checkOutOfRange(Integer lottoNumber) {
        if (lottoNumber < Lotto.MIN_NUMBER || lottoNumber > Lotto.MAX_NUMBER) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private Set<Integer> checkDuplicate(List<Integer> candidateWinningNumbers) {
        Set<Integer> uniqueWinningNumbers = new HashSet<>(candidateWinningNumbers);
        if (candidateWinningNumbers.size() != uniqueWinningNumbers.size()) {
            throw new IllegalArgumentException(Error.WINNING_NUMBER_DUPLICATED.getMessage());
        }
        return uniqueWinningNumbers;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
