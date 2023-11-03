package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.repository.LottoRepository;

public class LottoMachine {
    public void issueLottoTicket() {
        Lotto lotto = new Lotto(createLottoNumbers());
        LottoRepository.add(lotto);
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
