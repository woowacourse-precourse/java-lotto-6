package lotto.controller;

import lotto.service.LottoService;
import lotto.view.LottoPrint;

public class LottoController {
    LottoService lottoService = new LottoService();
    LottoPrint lottoPrint = new LottoPrint();
    public void run(){
        purchaseLotto();
        inputPrizeNumber();
        winningStatics();
    }

    public void purchaseLotto(){
        lottoPrint.inputAmountPrint();
        lottoService.purchaseLotto();
    }

    public void inputPrizeNumber(){
        lottoPrint.inputPrizeNumberPrint();
        lottoService.inputPrimaryNumber();
        lottoPrint.inputBonusNumberPrint();
        lottoService.inputBonusNumber();
    }

    public void winningStatics(){
        lottoPrint.winningStaticsMent();
        lottoService.predictWinning();
    }
}
