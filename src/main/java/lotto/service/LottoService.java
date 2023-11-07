package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;

import java.util.List;

public class LottoService {

    public List<Lotto> issueLottos(long payment) {
        return LottoMachine.make(payment);
    }
}
