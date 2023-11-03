package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {
    public void issueLottoTicket() {
        Lotto lotto = new Lotto(createLottoNumbers());
        LottoTicket.add(lotto);
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
