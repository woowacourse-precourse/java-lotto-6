package lotto.controller;

import lotto.model.LottoService;
import lotto.model.User;

public class LottoController {

    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        User user = new User();
        lottoService.startService(user);
        lottoService.drawLotto();
    }
}
