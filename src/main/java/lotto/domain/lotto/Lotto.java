package lotto.domain.lotto;

import static lotto.domain.constant.LottoConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.LottoConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.LottoConstant.LOTTO_NUMBERS_SIZE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(
                String.format("%d개의 숫자로 이루어진 로또 번호를 입력해 주세요.", LOTTO_NUMBERS_SIZE)
            );
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);

        if (distinctNumbers.size() < LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean hasWrongNumber = numbers
            .stream()
            .anyMatch(number -> !isInRange(number));

        if (hasWrongNumber) {
            throw new IllegalArgumentException(
                String.format("로또 번호는 %d 이상 %d 이하여야 합니다.",
                    LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER)
            );
        }
    }

    private boolean isInRange(int number) {
        return number >= LOTTO_MINIMUM_NUMBER && number <= LOTTO_MAXIMUM_NUMBER;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
            .filter(numbers::contains)
            .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
