package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static lotto.LottoHandler.LOTTO_LAST_NUMBER;
import static lotto.LottoHandler.LOTTO_START_NUMBER;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 쉼표로 구분해서 입력해 주세요.");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < 1 || number > 45)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(
                            "[ERROR] " + LOTTO_START_NUMBER + " 이상 " + LOTTO_LAST_NUMBER + " 이하의 숫자를 입력해 주세요."
                    );
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }
}
