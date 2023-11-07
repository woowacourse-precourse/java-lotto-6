package lotto.v2.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.v2.util.LottoConstantsV2;

import java.util.List;

public class LottoMachineV2 {
    public LottoV2 generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConstantsV2.LOTTO_NUMBER_MIN.getValue(),
                LottoConstantsV2.LOTTO_NUMBER_MAX.getValue(),
                LottoConstantsV2.LOTTO_NUMBERS_SIZE.getValue()
        );
        return new LottoV2(numbers);
    }

}
