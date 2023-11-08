package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int TOTAL_COUNT=6;
    private final List<Integer> randomNumbers;

    public RandomNumberGenerator() {
        this.randomNumbers = Randoms.pickUniqueNumbersInRange(START_NUMBER,END_NUMBER,TOTAL_COUNT);
    }
    public List<Integer> getRandomNumbers(){
        return randomNumbers;
    }
}
