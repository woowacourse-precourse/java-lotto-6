package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LotteryMachine {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private static final int DRAW_COUNT = 6;

    private static LotteryMachine lotteryMachine;

    private LotteryMachine(){
    }

    public static LotteryMachine getInstance(){
        if (lotteryMachine == null){
            lotteryMachine = new LotteryMachine();
        }
        return lotteryMachine;
    }

    public List<Integer> draw(){
        return Randoms.pickUniqueNumbersInRange(MINIMUM, MAXIMUM, DRAW_COUNT);
    }
}
