package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.LottoServiceImpl;
import lotto.view.LottoUI;

public class LottoController {
    private LottoService lottoService;
    private LottoUI lottoUI;

    public LottoController() {
        this.lottoService = new LottoServiceImpl();
        this.lottoUI = new LottoUI();
    }

    public void run() {
        int amount = lottoUI.purchase();
        lottoService.saveUser(amount);
    }
}