package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.GameSetting;

import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(
                GameSetting.START_NUMBER.getValue(),
                GameSetting.END_NUMBER.getValue(),
                GameSetting.TICKET_SIZE.getValue());
    }
}
