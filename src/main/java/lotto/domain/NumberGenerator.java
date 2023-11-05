package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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
        return Randoms.pickUniqueNumbersInRange(LottoInfo.START_NUMBER, LottoInfo.END_NUMBER, LottoInfo.COUNT);
    }
}
