package lotto.controller.lottomaker;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class lottoMakerByRandom implements LottoMaker{
    @Override
    public List<Integer> makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
