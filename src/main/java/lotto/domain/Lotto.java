package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isNotSizeSix(numbers) || isDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(Message.INVALID_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private boolean isNotSizeSix(List<Integer> numbers) {
        return numbers.size() != NUMBERS_SIZE;
    }

    private boolean isDuplicateNumbers(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != NUMBERS_SIZE;
    }

    enum Message {
        INVALID_NUMBERS("로또는 중복되지 않는 6개의 숫자만 가능합니다.");
        private final String message;

        Message(String message) {
            this.message = String.format("[Error] %s", message);
        }

        public String getMessage() {
            return message;
        }
    }
}
