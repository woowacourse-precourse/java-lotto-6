package lotto.generator;

import static lotto.constant.LottoGameConfig.AMOUNT_OF_NUMBERS;
import static lotto.constant.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameConfig.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomUniqueListGenerator {

    public List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(),
                AMOUNT_OF_NUMBERS.getValue()
        );
    }
}
