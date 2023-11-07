package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.LottoNumberDTO;

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
        return new LottoNumberDTO(
                Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
