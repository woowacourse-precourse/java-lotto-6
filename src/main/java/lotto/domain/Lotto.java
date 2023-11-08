package lotto.domain;

import lotto.consts.Consts;
import lotto.enums.Rank;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Consts.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != Consts.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    public Rank getRank(List<Integer> winNums, int bonusNum) {
        long correctCount = numbers.stream()
                .filter(number -> winNums.contains(number))
                .count();

        return calculateRank((int) correctCount, bonusNum);
    }

    private Rank calculateRank(int correctCount, int bonusNum) {
        if(correctCount == Rank.FIRST.getCorrectCount()) {
            return Rank.FIRST;
        }

        if (correctCount == Rank.SECOND.getCorrectCount() && numbers.contains(bonusNum)) {
            return Rank.SECOND;
        }

        return Rank.of((correctCount >= Rank.FIFTH.getCorrectCount()) ? 8 - (int) correctCount : Rank.OTHER.getValue());
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }
}
