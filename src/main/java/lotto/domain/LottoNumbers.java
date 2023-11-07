package lotto.domain;

import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoNumbers {

    public LottoNumbers() {
    }


    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
