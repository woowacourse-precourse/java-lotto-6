package lotto.domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUM_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_NUM_SIZE;
    }

    public Rank calculateRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        // 매치 개수
        long count = this.numbers.stream()
                .filter(winningNumbers::hasDuplicate)
                .count();

        // 보너스 번호 매치 여부
        boolean matchBonus = this.numbers.stream()
                .anyMatch(bonusNumber::match);

        return Rank.valueOf(count, matchBonus);
    }

}
