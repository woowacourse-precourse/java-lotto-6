package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static boolean validate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("로또 번호는 중복되지 않는 6자리여야 합니다.");
            }

            for (int number : numbers) {
                if (number > 45 || number < 1) {
                    throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이여야 합니다.");
                }
            }
            return true;
        } catch (IllegalArgumentException e) {
            new IllegalArgumentExceptionHandler(e.getMessage());
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
