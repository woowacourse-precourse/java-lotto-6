package lotto;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    static final int SMALLEST_LOTTO_NUMBER = 1;
    static final int BIGGEST_LOTTO_NUMBER = 45;
    static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        countValidate(numbers);
        duplicateValidate(numbers);
        inRangeValidate(numbers);
        numbers.sort(Comparator.naturalOrder());
        this.numbers = numbers;
    }

    private void countValidate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개가 입력되어야 합니다.");
        }
    }

    private List<Integer> getNumbers() {
        return numbers;
    }

    private void duplicateValidate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void inRangeValidate(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < SMALLEST_LOTTO_NUMBER || number > BIGGEST_LOTTO_NUMBER) {
                throw new IllegalArgumentException("당첨 번호는 1~45의 숫자여야 합니다.");
            }
        }
    }

    public boolean isLottoNumberDuplicate(int bonusNumber) {
        return (numbers.contains(bonusNumber));
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int matchedNumberAmount(Lotto winningLotto) {
        return this.numbers.stream()
                .filter(target -> winningLotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(target))).toList().size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
