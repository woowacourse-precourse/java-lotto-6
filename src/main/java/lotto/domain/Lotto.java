package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateDuplicationLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자입니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if(!numbers.stream()
                .allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicationLottoNumber(List<Integer> numbers) {
        if(numbers.stream()
                .distinct()
                .count() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public int matchingLottoNumber(Lotto compareLotto) {
        Long matchCount = this.getLotto()
                .stream()
                .filter(number -> compareLotto.getLotto()
                        .stream()
                        .anyMatch(compareNumber -> compareNumber == number))
                .count();
        return Long.valueOf(matchCount).intValue();
    }

    public boolean matchingBonusNumber(int bonusNumber) {
        return this.getLotto()
                .stream()
                .anyMatch(number -> number.equals(bonusNumber));
    }
}
