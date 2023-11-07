package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.constant.Exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            throw new IllegalArgumentException(Exception.LOTTO_SIZE);
        }
        List<Integer> lotto = numbers.stream().distinct().toList();
        if (lotto.size() != COUNT) {
            throw new IllegalArgumentException(Exception.LOTTO_DUPLICATED);
        }
        if (getSizeInRange(lotto) != COUNT) {
            throw new IllegalArgumentException(Exception.LOTTO_RANGE);
        }
    }

    private int getSizeInRange(List<Integer> lotto) {
        return lotto.stream()
                .filter(number -> number >= MIN_RANGE && number <= MAX_RANGE)
                .toList().size();
    }

    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
    }


    List<Integer> getNumbers() {
        return numbers;
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
