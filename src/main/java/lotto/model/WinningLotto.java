package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(List<String> numbersStr) {
        validateEmpty(numbersStr);
        List<Integer> numbers = validateNotNumber(numbersStr);
        validateSixNumbersCount(numbers);
        validateInvalidLottoNumberRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private void validateEmpty(List<String> numbersStr) {
        if (String.join("", numbersStr).isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 비었습니다.");
        }
    }

    private List<Integer> validateNotNumber(List<String> numbersStr) {
        try {
            return numbersStr.stream()
                    .map(numberStr -> Integer.parseInt(numberStr))
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }

    private void validateSixNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 6개여야 합니다.");
        }
    }

    private void validateInvalidLottoNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또의 번호는 1~45 사이의 수여야 합니다.");
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        List<Integer> checkNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (checkNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 로또의 각 번호는 중복될 수 없습니다.");
            }
            checkNumbers.add(number);
        }
    }
}
