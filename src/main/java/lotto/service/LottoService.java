package lotto.service;

import lotto.domain.Lotto;

public class LottoService {
    private Lotto lotto;

    public void createLotto(LottoMoneyRequest request) {
        this.lotto = new Lotto(request.getMoney());
    }
}
