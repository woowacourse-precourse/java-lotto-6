package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER_COUNT = "로또 숫자 개수에 맞도록 입력해주세요.";
    private static final String INVALID_NUMBER_RANGE = "로또 숫자 범위에 맞도록 입력해주세요.";
    private static final String INVALID_DUPLICATION = "로또 숫자는 중복될 수 없습니다.";
    private static final int DEFAULT_PRICE = 1000;

    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static int payableCount(int money) {
        if (money % DEFAULT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 로또 금액으로 나누어 떨어지는 금액만 입력 가능합니다");
        }

        return money / DEFAULT_PRICE;
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != Set.copyOf(numbers).size()) {
            throw new IllegalArgumentException(INVALID_DUPLICATION);
        }

        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }

        if (numbers.stream().anyMatch(
                number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
        ) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    public String getInformation() {
        return numbers.toString();
    }
}
