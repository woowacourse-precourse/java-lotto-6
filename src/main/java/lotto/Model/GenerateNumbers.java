package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class GenerateNumbers {

    public static final int MIN_RANGE = 1;
    public static final int MAX_RANGE = 45;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> randomNumbers;

    public GenerateNumbers() {
        this.randomNumbers = getRandomNumbers();
    }

    private List<Integer> getRandomNumbers() {
        List<Integer> pickNumbers;

        pickNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);

        return pickNumbers;
    }

    public List<Integer> getNumbers() {
        return randomNumbers;
    }

}
