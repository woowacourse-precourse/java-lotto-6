package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || duplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() < numbers.size();
    }

    public static Lotto pickRandom() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortNumbers);

        return new Lotto(sortNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}