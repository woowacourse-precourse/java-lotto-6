package lotto.core;

import lotto.util.ExceptionHandler;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
    }

    private static void validateRange(List<Integer> numbers) {
        if (numbers.stream()
                .filter(num -> num < 1 || num > 45)
                .findFirst()
                .isPresent()) {
            String errorMsg = "[ERROR] 로또의 당첨 번호는 1~45 사이의 숫자여야 합니다.";
            ExceptionHandler.handleException(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            String errorMsg = "[ERROR] 로또의 당첨 번호는 6개의 숫자여야 합니다.";
            ExceptionHandler.handleException(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    private static void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            String errorMsg = "[ERROR] 로또의 당첨 번호는 중복되지 않아야 합니다.";
            ExceptionHandler.handleException(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                res += numbers.get(i) + "]";
                continue;
            }
            res += numbers.get(i) + ", ";
        }
        return res;
    }
}
