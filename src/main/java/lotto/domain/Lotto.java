package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int LOTTO_PRICE =1000;
    private static final int LOTTO_MIN_NUMBER=1;
    private static final int LOTTO_MAX_NUMBER=45;
    private static  final int LOTTO_SIZE=6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateChecker(numbers);
        this.numbers = numbers;
    }

    public Lotto makeTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateChecker(List<Integer> numbers) {
        List<Integer> checkedList = new ArrayList<>();
        for (int i = 0; i < LOTTO_SIZE; i++) {
            if (checkedList.contains(numbers.get(i))) {
                throw new IllegalArgumentException();
            } else {
                checkedList.add(numbers.get(i));
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getLottoPrice() {
        return this.LOTTO_PRICE;
    }
}
