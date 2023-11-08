package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.view.constant.Exception.LOTTO_DUPLICATED;
import static lotto.view.constant.Exception.LOTTO_SIZE;
import static lotto.view.constant.Exception.LOTTO_FORMAT;

public class Lotto {
    private final List<Integer> numbers;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int COUNT = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(LOTTO_SIZE);
        }
        checkDuplication(numbers);
        numbers.forEach(this::checkRange);
    }

    private void checkDuplication(List<Integer> numbers) {
        int nonDuplicationSize = numbers.stream()
                .distinct().toList()
                .size();
        if (nonDuplicationSize != COUNT) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED);
        }
    }

    protected void checkRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(LOTTO_FORMAT);
        }
    }

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
    }

    protected List<Integer> getNumbers() {
        return this.numbers;
    }

    public boolean contains(int bonus) {
        return this.numbers.contains(bonus);
    }

    public int countMatch(WinningLotto winningLotto) {
        this.numbers.retainAll(winningLotto.getNumbers());
        return this.numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
