package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;

import static java.util.Collections.*;

public class LotteryMachine {

    private LotteryMachine() { }

    public static LotteryMachine of() {
        return new LotteryMachine();
    }

    public WinnerTicket getWinningTicket() {
        List<Integer> availableNumbers = new ArrayList<>();
        for (int num = 1; num <= 45; num++) {
            availableNumbers.add(num);
        }

        shuffle(availableNumbers);
        List<Integer> lotto = availableNumbers.subList(0, 6);
        sort(lotto);
        int bonusNumber = availableNumbers.get(7);

        return WinnerTicket.of(new Lotto(lotto), bonusNumber);
    }

}
