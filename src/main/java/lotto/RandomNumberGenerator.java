package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    private List<Integer> randomNumber;

    public List<Integer> generateRandomNumber() {
        this.randomNumber = Randoms.pickUniqueNumbersInRange(1, 45,6);
        return this.randomNumber;
    }

    public List<Integer> getRandomNumber() {
        return this.randomNumber;
    }
}
