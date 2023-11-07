package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.Constants;

import java.util.List;

public class LotteryMachine {

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
        return Randoms.pickUniqueNumbersInRange(Constants.MINIMUM, Constants.MAXIMUM, Constants.DRAW_COUNT);
    }
}
