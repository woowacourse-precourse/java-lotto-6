package lotto.controller.lotto;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.controller.lotto.RandNumber.makeUniqueNumber;

public class lotteryController {

    public static List<Lotto> rotateLotteryCount(int count) {
        List<Lotto> lottery = new ArrayList<>();
        for (int i=0; i<count; i++) {
            lottery.add(makeLottery());
        }
        return lottery;
    }

    public static Lotto makeLottery() {
        Lotto lotto = null;
        List<Integer> number = makeUniqueNumber();;
        lotto = new Lotto(number);
        return lotto;
    }

    public static List<Integer> sortLottery(Lotto lotto) {
        List<Integer> sortNumbers = new ArrayList<>(lotto.getLotto());
        Collections.sort(sortNumbers);
        return sortNumbers;
    }
}
