package lotto;

import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;
import lotto.constant.OutputMessage;
import lotto.constant.Ranking;
import lotto.domain.BonusNumber;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String START_MESSAGE = "[";
    private static final String END_MESSAGE = "]";
    private static final int THIRD_RANKING_NUMBER = 5;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.COUNT.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NUMBER.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);
        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(this::isCorrectRange);
    }

    private void isCorrectRange(int number) {
        if (!(LottoConstant.START_NUMBER.getValue() <= number && number <= LottoConstant.END_NUMBER.getValue())) {
            ExceptionMessage exceptionMessage = ExceptionMessage.INCORRECT_RANGE;
            throw new IllegalArgumentException(exceptionMessage.getMessage());
        }
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public Ranking isWin(WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(winningLotto);
        boolean isMatchBonusNumber = hasBonusNumber(winningLotto.getBonusNumber(), matchCount);
        return Ranking.getRanking(matchCount, isMatchBonusNumber);
    }

    private int calculateMatchCount(WinningLotto winningLotto) {
        int count = 0;
        for (int i = 0; i < LottoConstant.COUNT.getValue(); i++) {
            if (winningLotto.isContain(numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonusNumber(BonusNumber bonusNumber, int count) {
        if (count != THIRD_RANKING_NUMBER) {
            return false;
        }
        return numbers.contains(bonusNumber.getValue());
    }

    public String getNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(START_MESSAGE);
        List<String> elements = numbers.stream()
                .map(Object::toString)
                .toList();
        stringBuilder.append(String.join(OutputMessage.NUMBER_DELIMITER.getMessage(), elements));
        stringBuilder.append(END_MESSAGE);
        return stringBuilder.toString();
    }
}
