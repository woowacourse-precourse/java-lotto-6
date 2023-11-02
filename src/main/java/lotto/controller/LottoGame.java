package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.MyLotto;
import lotto.model.NumberOfPurchaseLotto;
import lotto.view.Printer;

public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private MyLotto myLotto;

    public void run(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(payment);
        Printer.printNumberOfPurchaseLotto(numberOfPurchaseLotto.getNumberOfPurchaseLotto());
        Printer.printWhiteSpace();
        myLotto = new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto.getNumberOfPurchaseLotto()));
        Printer.printLottos(myLotto.getLottos());
    }
}
