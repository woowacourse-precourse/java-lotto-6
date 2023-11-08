package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumber {

    private final List<Integer> randomNumber;

    public RandomNumber() {
        this.randomNumber = generateRandomNumber();
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }

    private List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
