package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.GameConstant;

public class RandomNumberGenerator {
    public List<Integer> generateRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(GameConstant.NUMBER_MIN,
                GameConstant.NUMBER_MAX, GameConstant.NUMBER_SIZE);
    }
}
