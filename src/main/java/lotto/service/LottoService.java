package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constants.LottoRule;

import java.util.List;

public class LottoService {
    public static List<Integer> generateRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LottoRule.LOTTO_MIN_NUMBER.getNumber(), LottoRule.LOTTO_MAX_NUMBER.getNumber(), LottoRule.LOTTO_NUMBER_COUNT.getNumber());
    }
}
