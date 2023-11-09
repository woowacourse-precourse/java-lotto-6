package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Rule.MIN_NUMBER, Rule.MAX_NUMBER, Rule.MAX_LENGTH);
    }
}
