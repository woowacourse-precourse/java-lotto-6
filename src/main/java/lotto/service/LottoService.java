package lotto.service;

import lotto.model.Lottos;
import lotto.model.WinningLotto;

public class LottoService {
    private Lottos lottos;
    private WinningLotto winningLotto;
    private static LottoService instance;

    private LottoService() {}

    public static LottoService getInstance() {
        if(instance == null) {
            instance = new LottoService();
        }
        return instance;
    }
}
