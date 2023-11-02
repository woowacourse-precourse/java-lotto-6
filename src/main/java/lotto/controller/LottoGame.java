package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.MyLotto;
import lotto.view.Printer;

public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private MyLotto myLotto;

    public void run(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        int numberOfPurchaseLotto = payment / 1000;
        myLotto = new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto));
        Printer.printNumberOfPurchaseLotto(numberOfPurchaseLotto);
        Printer.printLottos(myLotto.getLottos());
    }
}
