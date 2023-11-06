package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLotteryNumberProvider {

    private static int LOTTERY_NUMBER_COUNT = 6;
    private static int MAX_INCLUDE = 45;
    private static int MIN_INCLUDE = 1;

    public static List<Integer> lotteryNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_INCLUDE, MAX_INCLUDE, LOTTERY_NUMBER_COUNT);
    }
}
