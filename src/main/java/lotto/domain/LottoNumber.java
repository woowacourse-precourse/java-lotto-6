package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void drawWiningNumbers(String value) {
        checkWinningNumbers(value);
        winningNumbers = toListInteger(value);
    }

    public void drawBonusNumber(String value) {
        checkBonusNumber(value);
        bonusNumber = Integer.parseInt(value);
    }

    private void checkWinningNumbers(String value) {
        validateEmpty(value);
        validateOnlyNumberAndComma(value);
        validateValueExists(value);
        List<Integer> numbers = toListInteger(value);
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void checkBonusNumber(String value) {
        validateEmpty(value);
        validateOnlyNumber(value);
        validateRangeOfBonus(value);
        validateDuplicateWinningNumbers(value);
    }

    private List<Integer> toListInteger(String value) {
        List<String> values = Arrays.asList(value.split(","));
        List<Integer> numbers = values.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        return numbers;
    }

    private void validateEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 없습니다.");
        }
    }

    private void validateOnlyNumberAndComma(String value) {
        String removeComma = value.replace(",","");
        try {
            Integer.parseInt(removeComma);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백 없이 쉼표(,)로 구분된 숫자로만 입력해주세요.");
        }
    }

    private void validateValueExists(String value) {
        List<String> numbers = Arrays.asList(value.split(","));
        for (String number : numbers) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 입력되지 않은 번호가 있습니다.");
            }
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().filter(n -> (n >= 1) && (n <= 45)).count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateOnlyNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private void validateRangeOfBonus(String value) {
        int number = Integer.parseInt(value);
        if ((number < 1) || (number > 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateDuplicateWinningNumbers(String value) {
        int number = Integer.parseInt(value);
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == number) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
            }
        }
    }
}
