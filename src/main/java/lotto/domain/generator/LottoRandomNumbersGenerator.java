package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoConstant;

public class LottoRandomNumbersGenerator implements LottoNumbersGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_NUMBER_MIN,
                LottoConstant.LOTTO_NUMBER_MAX,
                LottoConstant.LOTTO_NUMBERS_COUNT
        );
    }
}
