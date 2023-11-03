package lotto.model.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private final int minNumber = LottoGameConstants.MIN_NUMBER.getValue();
    private final int maxNumber = LottoGameConstants.MAX_NUMBER.getValue();
    private final int numbersPerLotto = LottoGameConstants.NUMBERS_PER_LOTTO.getValue();

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, numbersPerLotto);
    }
}
