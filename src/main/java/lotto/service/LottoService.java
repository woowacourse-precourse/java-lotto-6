package lotto.service;

import lotto.domain.Lottos;
import lotto.dto.MoneyRequest;

public class LottoService {
    private Lottos lottos;

    public void createLottos(MoneyRequest request) {
        int count = request.getMoney()/1000;
        this.lottos = new Lottos(count);
    }
}
