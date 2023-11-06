package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.service.WinningNumberService;

public class LotteryGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    private Lotto lotto;

    private void generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        WinningNumberService winningNumberService = new WinningNumberService();
        do {
            numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER,NUMBER_SIZE);

        } while (!winningNumberService.verifyDuplication(numbers));

        this.lotto = new Lotto(numbers);
    }

    public Lotto getLotto() {
        generateLotto();
        return lotto;
    }

}
