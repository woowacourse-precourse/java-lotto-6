package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.UtilNumber.*;

public class LottoMachine {

    public static Lotto createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getNumber(), MAX_LOTTO_NUMBER.getNumber(), LOTTO_LENGTH.getNumber());
        return new Lotto(lottoNumbers);
    }
}
