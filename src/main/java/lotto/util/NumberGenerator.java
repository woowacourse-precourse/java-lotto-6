package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.constant.LottoNumberComposition.*;

public class NumberGenerator {
    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER.getNumber(),END_NUMBER.getNumber(),ENTER_COUNT.getNumber());
    }
}
