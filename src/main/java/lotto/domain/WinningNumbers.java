package lotto.domain;

import static common.enumtype.ErrorCode.BONUS_NUMBER_ALREADY_REGISTER;
import static common.enumtype.ErrorCode.WINNING_NUMBERS_CONTAIN_BONUS_NUMBER;
import static common.enumtype.ErrorCode.WINNING_NUMBERS_DUPLICATED;
import static common.enumtype.ErrorCode.WINNING_NUMBERS_INVALID_SIZE;
import static java.util.stream.Collectors.toList;

import common.enumtype.ResultType;
import common.exception.InvalidArgumentException;
import common.exception.InvalidStatementException;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WinningNumbers {

    private static final int VALID_SIZE = 6;

    private final List<WinningNumber> winningNumbers;
    private WinningNumber bonusNumber;

    public WinningNumbers(List<Integer> numbers) {
        validateNumbers(numbers);
        this.winningNumbers = convertWinningNumbers(numbers);
    }

    public void registerBonusNumber(int number) {
        if (!isNullBonusNumber()) {
            throw new InvalidStatementException(BONUS_NUMBER_ALREADY_REGISTER);
        }

        WinningNumber bonusNumber = new WinningNumber(number);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public ResultType matchingResult(List<Integer> numbers) {
        int matchingCount = getMatchingCount(numbers);
        boolean isBonusMatching = isBonusMatching(numbers);
        if (isBonusMatching) {
            matchingCount++;
        }
        return ResultType.valueOf(matchingCount, isBonusMatching);
    }

    private boolean isBonusMatching(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(bonusNumber::equalsTo);
    }

    private int getMatchingCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this::isMatchingNumber)
                .count();
    }

    private boolean isMatchingNumber(Integer number) {
        return winningNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.equalsTo(number));
    }

    private List<WinningNumber> convertWinningNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(WinningNumber::new)
                .collect(toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new InvalidArgumentException(WINNING_NUMBERS_INVALID_SIZE);
        }

        if (!isUniqueNumbers(numbers)) {
            throw new InvalidArgumentException(WINNING_NUMBERS_DUPLICATED);
        }
    }

    private boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == VALID_SIZE;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }

    private boolean isNullBonusNumber() {
        return Objects.isNull(this.bonusNumber);
    }

    private void validateBonusNumber(WinningNumber bonusNumber) {
        if (!isUniqueBonusNumber(bonusNumber)) {
            throw new InvalidArgumentException(WINNING_NUMBERS_CONTAIN_BONUS_NUMBER);
        }
    }

    private boolean isUniqueBonusNumber(WinningNumber bonusNumber) {
        return !winningNumbers.contains(bonusNumber);
    }
}
