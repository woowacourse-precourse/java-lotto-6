package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LotteryGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private Lotto lotto;

    private void generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        do {
            int pickNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            if (!numbers.contains(pickNumber)) {
                numbers.add(pickNumber);
            }
        } while (numbers.size() != NUMBER_SIZE);
//        System.out.println(numbers.toString());
        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        generateLotto();
        return lotto;
    }

}
