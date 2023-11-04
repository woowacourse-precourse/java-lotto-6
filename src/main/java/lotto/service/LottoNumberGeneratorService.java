package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static lotto.domain.LottoRule.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoRule.MIN_LOTTO_NUMBER;

import lotto.domain.LottoNumber;

public class LottoNumberGeneratorService {

    public LottoNumber generate() {
        return LottoNumber.from(pickNumberInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue()));
    }
}
