package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoPrint;

public class LottoController {
    LottoService lottoService = new LottoService();
    LottoPrint lottoPrint = new LottoPrint();
    public void run(){
        purchaseLotto();
    }

    public void purchaseLotto(){
        lottoPrint.inputAmountPrint();
        lottoService.purchaseLotto();
    }
}
