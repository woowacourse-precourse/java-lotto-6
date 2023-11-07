package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class LottoMachine {
    public static Lotto createLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(lottoNumbers);
    }
}
