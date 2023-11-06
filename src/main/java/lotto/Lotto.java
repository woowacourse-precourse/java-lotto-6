package lotto;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;
    private final Bonus bonus;

    public Lotto(List<Integer>numbers) {
        this(numbers, new Bonus());
    }

    public Lotto(List<Integer> numbers, Bonus bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 되어있어야 합니다.");
        }
    }

    public String toTextFormat() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> sb.append(number)
                .append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public boolean isJackpotLotto() {
        return bonus.isJackpot() ;
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
            count += 2;
        }
        return count;
    }

    private boolean hasMatchingNumber(Integer targetNumber) {
        return numbers.stream()
                .anyMatch(Predicate.isEqual(targetNumber));
    }

    private boolean hasBonusNumberMatching(long count, Integer bonusNumber) {
        return count == 5L && numbers.contains(bonusNumber);
    }
}
