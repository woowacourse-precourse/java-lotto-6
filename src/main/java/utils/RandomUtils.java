package utils;

import camp.nextstep.edu.missionutils.Randoms;
import constants.NumberType;
import java.util.List;

public class RandomUtils {

    public static List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(NumberType.MIN_LOTTO_NUMBER.getValue(),
                NumberType.MAX_LOTTO_NUMBER.getValue(), NumberType.LOTTO_LENGTH.getValue());
    }
}
