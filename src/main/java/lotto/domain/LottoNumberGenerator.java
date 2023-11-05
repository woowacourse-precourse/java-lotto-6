package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.Constants;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generatorLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(Constants.MIN_NUM,Constants.MAX_NUM,Constants.PICK_NUM);
    }
}
