package lotto.domain;

import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

import static constant.MessageList.PRICE_OF_ONE_LOTTO;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = generateLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
