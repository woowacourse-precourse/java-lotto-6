package lotto.controller;

import lotto.model.*;
import lotto.view.Printer;


public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private MyLotto myLotto;

    public void run(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(payment);
        myLotto = new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto.getNumberOfPurchaseLotto()));
        Printer.printLottos(myLotto.getLottos());
        WinningLotto winningLotto  = new WinningLotto(inputDevice.inputWinningNumbers());
    }
}
