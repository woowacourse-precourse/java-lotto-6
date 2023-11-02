package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class LotteryNumberGenerator {

    public LotteryNumberGenerator(){}

    private static List<Integer> generateLotteryNumber(){
        List<Integer> lottertyNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottertyNumbers;
    }

    public static Lotto generateLotto(){
        Lotto lotto = new Lotto(generateLotteryNumber());
        return lotto;
    }

}
