package lotto.random;

import static lotto.Constants.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGeneratorImpl implements RandomNumberGenerator {


    @Override
    public List<Integer> generateRandomNumbers() {
        return
            Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                LOTTO_NUMBER_LENGTH);
    }
}
