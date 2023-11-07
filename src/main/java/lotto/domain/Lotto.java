package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumberRange(numbers);
        validateDuplicationNumber(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toStringLotto() {
        return numbers.toString();
    }

    public void sortNumbers() {
        Collections.sort(numbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) lotto.numbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isContainNumber(int number) {
        if (!numbers.contains(number)) {
            return false;
        }
        return true;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 현재 로또가 6개의 숫자를 포함하고 있지 않습니다.");
        }
    }

    private void validateDuplicationNumber(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();
        if (count != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또에 중복된 숫자가 포함되어 있습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.stream().filter(number -> number < 1 || number > 45)
                .forEach(number -> {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자만 포함되어야 합니다.");
        });
    }
}
