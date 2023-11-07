package lotto.service;

import lotto.domain.Budget;
import lotto.domain.Lottos;

public class LottoService {

    public Lottos createLottos(Budget budget){
        return Lottos.createLottos(budget);
    }

    public int getLottosSize(Lottos lottos){
        return lottos.getLottosSize();
    }

    public String getLottosNumbers(Lottos lottos){
        return lottos.getLottosNumbers();
    }
}
