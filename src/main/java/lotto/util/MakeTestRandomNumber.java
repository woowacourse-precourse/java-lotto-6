package lotto.util;

import java.util.List;

public class MakeTestRandomNumber implements RandomNum {
    private final List<Integer> randomNumber;

    public MakeTestRandomNumber(List<Integer> randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
