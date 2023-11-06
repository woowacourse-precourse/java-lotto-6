package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberLength(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] : 로또 번호는 6개 입니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] : 중복된 숫자가 로또 번호에 있으면 안됩니다.");
            }
        }
    }

    private void validateNumberLength(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] : 로또 번호는 1부터 45 사이어야 합니다.");
            }
        }
    }

    public int countCorrectLottoNumbers(Lotto answerLotto) {
        return (int) numbers.stream()
                .filter(answerLotto::contains)
                .count();
    }

    public boolean contains(int lottoNumber) {
        return this.numbers.contains((lottoNumber));
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }
}
