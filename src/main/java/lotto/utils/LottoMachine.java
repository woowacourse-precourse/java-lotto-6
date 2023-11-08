package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.exception.LottoGameException;

import java.util.List;

import static lotto.utils.UtilNumber.*;

public class LottoMachine {

    public static Lotto createLotto() throws LottoGameException {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getNumber(), MAX_LOTTO_NUMBER.getNumber(), LOTTO_LENGTH.getNumber());
        return new Lotto(lottoNumbers);
    }
}
