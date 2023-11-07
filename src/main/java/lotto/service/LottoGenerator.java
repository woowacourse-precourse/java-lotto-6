package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;

import static lotto.constants.LottoSetting.*;

public class LottoGenerator {

    public Lotto issueLottoTicket() {
        return new Lotto(generateUniqueRandomNumbers());
    }


    private List<Integer> generateUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.value(), MAX_LOTTO_NUMBER.value(), LOTTO_SIZE.value());
    }

}
