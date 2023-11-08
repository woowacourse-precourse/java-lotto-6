package lotto.model.domain;

import static lotto.exception.ExceptionMessage.DUPLICATION_EXCEPTION;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    private static final int PRICE = 1000;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int NUMBER_COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        HashSet<Integer> set = new HashSet<>();

        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(DUPLICATION_EXCEPTION.getMessage());
            }
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE,
            NUMBER_COUNT);
        return new Lotto(numbers);
    }

    public static int calculatePurchaseQuantity(int purchaseCostInput) {
        return purchaseCostInput / PRICE;
    }
}
