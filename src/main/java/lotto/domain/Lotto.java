package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import lotto.domain.vo.Bonus;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String FORMAT_STARTER = "[";
    private static final String DIVIDER = ", ";
    private static final String FORMAT_ENDER = "]";
    private static final int BONUS_IDENTIFIER = 2;
    private static final long MATCHING_FIVE = 5L;

    private final List<Integer> numbers;
    private final Bonus bonus;

    public Lotto(List<Integer> numbers) {
        this(numbers, new Bonus());
    }

    public Lotto(List<Integer> numbers, Bonus bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 되어있어야 합니다.");
        }
    }

    public String toTextFormat() {
        StringBuilder sb = new StringBuilder(FORMAT_STARTER);
        numbers.forEach(number -> sb.append(number)
                .append(DIVIDER));
        sb.delete(sb.length() - 2, sb.length());
        sb.append(FORMAT_ENDER);
        return sb.toString();
    }

    public boolean isJackpotLotto() {
        return bonus.isJackpot();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public Integer getBonusNumber() {
        if (!bonus.isJackpot()) {
            throw new IllegalArgumentException("당첨용 로또가 아닙니다.");
        }
        return bonus.getBonusNumber();
    }

    public long countMatchingNumbers(Lotto jackpotLotto) {
        long count = jackpotLotto.getNumbers()
                .stream()
                .filter(this::hasMatchingNumber)
                .count();
        if (hasBonusNumberMatching(count, jackpotLotto.getBonusNumber())) {
            count += BONUS_IDENTIFIER;
        }
        return count;
    }

    private boolean hasMatchingNumber(Integer targetNumber) {
        return numbers.stream()
                .anyMatch(Predicate.isEqual(targetNumber));
    }

    private boolean hasBonusNumberMatching(long count, Integer bonusNumber) {
        return count == MATCHING_FIVE && numbers.contains(bonusNumber);
    }
}
