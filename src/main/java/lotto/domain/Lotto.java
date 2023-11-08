package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int SIZE = 6;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isOutSize(numbers)) {
            throw new IllegalArgumentException(Message.INVALID_SIZE.getMessage());
        }
        if (isNotUnique(numbers)) {
            throw new IllegalArgumentException(Message.INVALID_UNIQUE.getMessage());
        }
        if (isOutRange(numbers)) {
            throw new IllegalArgumentException(Message.INVALID_RANGE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private boolean isOutSize(List<Integer> numbers) {
        return numbers.size() != SIZE;
    }

    private boolean isOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch((number) -> (number < MIN || number > MAX));
    }

    private boolean isNotUnique(List<Integer> numbers) {
        return Set.copyOf(numbers).size() != SIZE;
    }

    enum Message {
        INVALID_SIZE("로또 번호는 6개의 숫자만 가능합니다."),
        INVALID_UNIQUE("로또 번호는 중복되지 않는 숫자만 가능합니다."),
        INVALID_RANGE("로또 번호의 숫자 범위는 1~45까지만 가능합니다.");

        private final String message;

        Message(String message) {
            this.message = String.format("[Error] %s", message);
        }

        public String getMessage() {
            return message;
        }
    }
}
