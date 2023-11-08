package lotto.domain.lottogenerator;

import static lotto.domain.constant.LottoConstant.LOTTO_MAXIMUM_NUMBER;
import static lotto.domain.constant.LottoConstant.LOTTO_MINIMUM_NUMBER;
import static lotto.domain.constant.LottoConstant.LOTTO_NUMBERS_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.lotto.Lotto;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public Lotto generate() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(
            LOTTO_MINIMUM_NUMBER, LOTTO_MAXIMUM_NUMBER, LOTTO_NUMBERS_SIZE);

        return new Lotto(lottoNumbers);
    }
}
