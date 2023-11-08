package lotto.model.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.common.constants.LottoRank;
import lotto.common.constants.LottoRule;
import lotto.common.exception.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        validateLottoNumberRange(numbers);

        this.numbers = new ArrayList<>(numbers);
        sort(this.numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers != null && numbers.size() != LottoRule.LOTTO_NUMBER_SIZE.value) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getValue(numbers));
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LottoRule.LOTTO_NUMBER_MIN.value || LottoRule.LOTTO_NUMBER_MAX.value < number) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue(numbers));
            }
        });
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoRule.LOTTO_NUMBER_SIZE.value) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_LOTTO_NUMBER.getValue(numbers));
        }
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public LottoRank calculateLottoRank(WinningTicket winningTicket) {
        int matchingCount = getMatchingCount(winningTicket.lotto());
        boolean hasBonusBall = hasBonusBall(winningTicket.bonusBall());
        return LottoRank.from(matchingCount, hasBonusBall);
    }

    private int getMatchingCount(Lotto compare) {
        return (int) compare.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean hasBonusBall(BonusBall bonusBall) {
        return numbers.contains(bonusBall.number());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;

        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        if (numbers == null) {
            return 0;
        }
        return numbers.hashCode();
    }

    @Override
    public String toString() {
        return "Lotto" + numbers;
    }
}
