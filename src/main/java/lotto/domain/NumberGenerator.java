package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.domain.LottoCondition.*;

public class NumberGenerator {

    private NumberGenerator() {
    }

    private static class NumberGeneratorHolder {
        private static NumberGenerator numberGenerator = new NumberGenerator();
    }

    public static NumberGenerator getInstance() {
        return NumberGeneratorHolder.numberGenerator;
    }

    public List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER.getValue(), END_NUMBER.getValue(), COUNT.getValue());
    }
}
