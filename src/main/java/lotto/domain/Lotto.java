package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int NUMBERS_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNotSizeSix(numbers) || isDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(Message.INVALID_NUMBERS.getMessage());
        }
        if (isOutRange(numbers)) {
            throw new IllegalArgumentException(Message.INVALID_RANGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private boolean isNotSizeSix(List<Integer> numbers) {
        return numbers.size() != NUMBERS_SIZE;
    }

    private boolean isOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch((number) -> (number < MIN_NUMBER || number > MAX_NUMBER));
    }

    private boolean isDuplicateNumbers(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != NUMBERS_SIZE;
    }

    enum Message {
        INVALID_NUMBERS("로또는 중복되지 않는 6개의 숫자만 가능합니다."),
        INVALID_RANGE("로또 번호의 숫자 범위는 1~45만 가능합니다.");
        private final String message;

        Message(String message) {
            this.message = String.format("[Error] %s", message);
        }

        public String getMessage() {
            return message;
        }
    }
}
