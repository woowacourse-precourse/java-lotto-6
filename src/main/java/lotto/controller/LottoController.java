package lotto.controller;

import lotto.model.LottoService;
import lotto.model.dto.PayDTO;
import lotto.view.BeforeScreen;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        PayDTO pay = BeforeScreen.readPayment();
        this.lottoService = new LottoService(pay.getNumberOfLotto());
    }
    public void execute(){

    }
}
