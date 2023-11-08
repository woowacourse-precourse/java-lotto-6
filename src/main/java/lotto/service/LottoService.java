package lotto.service;

import lotto.domain.Budget;
import lotto.domain.LottoSize;
import lotto.domain.Lottos;

public class LottoService {

    public Lottos createLottos(Budget budget){
        return Lottos.createLottos(budget);
    }

    public LottoSize getLottosSize(Lottos lottos){
        return new LottoSize(lottos.getLottosSize());
    }

    public String getLottosNumbers(Lottos lottos) {
        return lottos.getLottosNumbers();
    }
}
