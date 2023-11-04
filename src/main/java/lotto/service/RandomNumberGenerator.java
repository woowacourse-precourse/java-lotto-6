package lotto.service;

import static lotto.constant.LottoSetting.LOTTO_NUMBERS;
import static lotto.constant.LottoSetting.MAX_RANDOM_NUMBER;
import static lotto.constant.LottoSetting.MIN_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                        MIN_RANDOM_NUMBER.getValue(),
                        MAX_RANDOM_NUMBER.getValue(),
                        LOTTO_NUMBERS.getValue())
                .stream().sorted().toList();
    }
}
