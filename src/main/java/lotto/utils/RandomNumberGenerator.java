package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import lotto.Lotto;

public class RandomNumberGenerator implements NumberGenerator {

    private final int min;
    private final int max;

    public RandomNumberGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Lotto generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != 6) {
            int randomNumber = pickRandomNumber();
            numbers.add(randomNumber);
        }
        return new Lotto(new ArrayList<>(numbers));
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(min, max);
    }
}
