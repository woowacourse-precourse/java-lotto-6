package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMachine {
    public static Lotto createLotto(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        return new Lotto(lottoNumbers);
    }
}
