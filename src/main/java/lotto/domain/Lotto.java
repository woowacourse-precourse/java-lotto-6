package lotto.domain;

import lotto.dto.AnswerLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.LottoConstant.*;

public class Lotto {

    private static final int REQUIRED_MATCHING_NUMBERS_FOR_BONUS = 5;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호들은 중복 될 수 없습니다.");
        }

    }

    public Rank calculateLottoWinnings(AnswerLotto answerLotto) {
        List<Integer> answerNumbers = answerLotto.getAnswerNumbers();
        int bonusNumber = answerLotto.getBonusNumber();
        int matchedNumber = 0;

        for (int i = 0; i < LOTTO_NUMBERS_SIZE; i++) {
            for (int j = 0; j < LOTTO_NUMBERS_SIZE; j++) {
                matchedNumber = getMatchedNumber(matchedNumber, numbers.get(i), answerNumbers.get(j));
            }
        }
        return Rank.findRankByMatchedNBonusNumber(matchedNumber, hasBonusNumber(bonusNumber, matchedNumber));
    }

    private boolean hasBonusNumber(int bonusNumber, int matchedNumber) {
        if (matchedNumber == REQUIRED_MATCHING_NUMBERS_FOR_BONUS) {
            return numbers.stream()
                    .anyMatch(number -> number == bonusNumber);
        }
        return false;
    }

    private int getMatchedNumber(int matchedNumber, Integer number, Integer answerNumber) {
        if (number == answerNumber) {
            matchedNumber++;
        }
        return matchedNumber;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
