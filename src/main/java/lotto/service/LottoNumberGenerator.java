package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.LottoNumberDTO;

import static lotto.constant.CommonUnits.*;

public class LottoNumberGenerator {
    private static LottoNumberGenerator lottoNumberGenerator;

    private LottoNumberGenerator() {}

    public static LottoNumberGenerator getLottoNumberGenerator() {
        if (lottoNumberGenerator == null) {
            lottoNumberGenerator = new LottoNumberGenerator();
        }
        return lottoNumberGenerator;
    }

    public LottoNumberDTO generate() {
        return new LottoNumberDTO(Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBERS_OF_LOTTO));
    }
}
