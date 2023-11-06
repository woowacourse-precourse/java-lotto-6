package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;

    private NumberGenerator() {
    }

    private static class NumberGeneratorHolder {
        private static NumberGenerator numberGenerator = new NumberGenerator();
    }

    public static NumberGenerator getInstance() {
        return NumberGeneratorHolder.numberGenerator;
    }

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
    }
}
