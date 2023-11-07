package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_SIZE = 6;
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE));
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
        }
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException("로또 숫자는 1부터 45 사이어야 합니다.");
            }
        }
    }
}
