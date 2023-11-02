package lotto.controller;

import lotto.model.*;
import lotto.view.Printer;

import java.util.List;


public class LottoGame {
    private final InputDevice inputDevice = new InputDevice();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final WinningCountMachine winningCountMachine = new WinningCountMachine();
    private final TotalReturnCalculator totalReturnCalculator = new TotalReturnCalculator();

    public void run(){
        NumberOfPurchaseLotto numberOfPurchaseLotto = makeNumberOfPurchaseLotto();
        MyLotto myLotto = makeMyLotto(numberOfPurchaseLotto.getNumberOfPurchaseLotto());
        Printer.printLottos(myLotto.getLottos());
        WinningLotto winningLotto = makeWinningLotto();
        WinningDetail winningDetail = winningCountMachine.maketWinningDetail(winningLotto, myLotto);
        Printer.printWinningDetail(winningDetail);
        Double totalReturn = totalReturnCalculator.calculateTotalReturn(winningDetail, numberOfPurchaseLotto);
        Printer.printTotalReturn(totalReturn);
    }

    private NumberOfPurchaseLotto makeNumberOfPurchaseLotto(){
        Integer payment = inputDevice.inputLottoPurchasePayment();
        NumberOfPurchaseLotto numberOfPurchaseLotto = new NumberOfPurchaseLotto(payment/LottoPrice.PRICE.getValue());
        return numberOfPurchaseLotto;
    }

    private MyLotto makeMyLotto(int numberOfPurchaseLotto){
        MyLotto myLotto = new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto));
        return myLotto;
    }

    private WinningLotto makeWinningLotto(){
        List<Integer> winningNumbers = inputDevice.inputWinningNumbers();
        Integer bonusNumber = inputDevice.inputBonusNumber(winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        return winningLotto;
    }
}
