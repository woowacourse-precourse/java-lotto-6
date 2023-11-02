package lotto.controller;

import lotto.model.*;
import lotto.view.Printer;

import java.util.List;


public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final WinningCountMachine winningCountMachine = new WinningCountMachine();
    private MyLotto myLotto;

    public void run(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(payment);
        myLotto = new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto.getNumberOfPurchaseLotto()));
        Printer.printLottos(myLotto.getLottos());
        List<Integer> winningNumbers = inputDevice.inputWinningNumbers();
        Integer bonusNumber = inputDevice.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        WinningDetail winningDetail = winningCountMachine.maketWinningDetail(winningLotto, myLotto);
        Printer.printWinningDetail(winningDetail);
    }
}
