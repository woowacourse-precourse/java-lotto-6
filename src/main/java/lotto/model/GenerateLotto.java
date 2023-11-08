package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.constant.LottoConstant;

import java.util.List;
import java.util.Random;

public class GenerateLotto {

    public Lotto generateLotto(){
        return new Lotto(generate());
    }
    private List<Integer> generate(){
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.START_INCLUSIVE.getConstant(),
                LottoConstant.END_INCLUSIVE.getConstant(),
                LottoConstant.LOTTO_NUMBER_SIZE.getConstant());
    }
}
