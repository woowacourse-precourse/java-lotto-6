package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    protected static final Integer MAX_LOTTO_NUMBER = 45;
    protected static final Integer MIN_LOTTO_NUMBER = 1;
    protected static final Integer LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String winningNumbers) {
        List<Integer> numbers = new ArrayList<>();

        validateConvertBeforeNumbers(winningNumbers);
        String[] parserNumber = winningNumbers.split(",");
        for (String currentNumber : parserNumber) {
            numbers.add(convertStringToInteger(currentNumber));
        }
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNotNullNumber(numbers);
        validateOutOfRangeNumber(numbers);
        validateDuplicatedNumber(numbers);
        validateLengthOfNumber(numbers);
    }

    private void validateConvertBeforeNumbers(String winningNumbers) {
        validateNotNullNumber(winningNumbers);
        validateNonNumericNumbers(winningNumbers);
    }

    private void validateNonNumericNumbers(String bonusNumber) {
        if (!bonusNumber.matches("^[0-9,]*")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 숫자가 아닌 값이 들어왔습니다.");
        }
    }

    private void validateNotNullNumber(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_NUMBER_SIZE + "개의 로또번호를 입력해주세요");
        }
    }

    private void validateNotNullNumber(String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_NUMBER_SIZE + "개의 로또번호를 입력해주세요");
        }
    }

    private void validateLengthOfNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_NUMBER_SIZE + "개의 로또번호를 입력해주세요");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                .distinct()
                .count() < numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다");
        }
    }

    private void validateOutOfRangeNumber(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num -> num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
                  + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
    }

    protected boolean isInputNumberContainLottoNumbers(Integer inputNumber) {
        return (numbers.contains(inputNumber));
    }

    protected Integer convertStringToInteger(String numbers) {
        Integer convertNumbers;

        try {
            convertNumbers = Integer.parseInt(numbers);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 지정된 범위안의 숫자로 넣어주세요. 범위 "
                    + MIN_LOTTO_NUMBER + "~" + MAX_LOTTO_NUMBER);
        }
        return convertNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
