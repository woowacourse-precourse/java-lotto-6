package lotto.model;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int LOTTO_LOWER_INCLUSIVE = 1;
    public static final int LOTTO_UPPER_INCLUSIVE = 45;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateInRange(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateInRange(List<Integer> numbers) {
        numbers.forEach(number ->{
            if(isOutRange(number)){
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 값이어야 합니다.");
            }
        });
    }

    private boolean isOutRange(Integer number) {
        return number < LOTTO_LOWER_INCLUSIVE || number > LOTTO_UPPER_INCLUSIVE;
    }


}
