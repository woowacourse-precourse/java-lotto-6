package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoTicket {
    private List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = issueSixNumbers();
    }

    private List<Integer> issueSixNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
