package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LotteryGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private Lotto lotto;

    public Lotto getLotto() {
        generateLotto();
        return lotto;
    }

    private void generateLotto() {
        List<Integer> numbers;
        numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER,NUMBER_SIZE);

        this.lotto = new Lotto(numbers);
    }
}
