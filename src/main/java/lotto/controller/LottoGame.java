package lotto.controller;

import lotto.model.*;
import lotto.view.Printer;

import java.util.List;


public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final WinningCountMachine winningCountMachine = new WinningCountMachine();

    public void run(){
        MyLotto myLotto = makeMyLotto();
        Printer.printLottos(myLotto.getLottos());
        WinningLotto winningLotto = makeWinningLotto();
        WinningDetail winningDetail = winningCountMachine.maketWinningDetail(winningLotto, myLotto);
        Printer.printWinningDetail(winningDetail);
    }

    private MyLotto makeMyLotto(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(payment);
        MyLotto myLotto = new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto.getNumberOfPurchaseLotto()));
        return myLotto;
    }

    private WinningLotto makeWinningLotto(){
        List<Integer> winningNumbers = inputDevice.inputWinningNumbers();
        Integer bonusNumber = inputDevice.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }
}
