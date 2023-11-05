package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int PRICE = 1000;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] " + numbers.size() + "개의 숫자가 입력되었습니다.");
        }

        if (numbers.stream().anyMatch(Lotto::isOutOfRange)) {
            throw new IllegalArgumentException("[ERROR] 범위 안의 숫자를 입력해주세요.");
        }

        if (hasDuplicated(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다.");
        }
    }

    private boolean hasDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static int purchaseCount(int pay) {
        if (pay % PRICE != 0) {
            throw new IllegalArgumentException();
        }

        return pay / PRICE;
    }

    public static boolean isOutOfRange(Integer number) {
        return number < LOWER_BOUND || number > UPPER_BOUND;
    }
}
