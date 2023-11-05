package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.config.LottoConfig.*;

public class LottoNumber {

    public List<Integer> lottoRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER.getValue()
                , LOTTO_MAX_NUMBER.getValue(), LOTTO_COUNT.getValue());

        return numbers;
    }

}
