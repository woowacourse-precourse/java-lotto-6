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
        return new NumberOfPurchaseLotto(payment/ LottoMetaData.PRICE.getValue());
    }

    private MyLotto makeMyLotto(int numberOfPurchaseLotto){
        return new MyLotto(lottoGenerator.generateLottos(numberOfPurchaseLotto));
    }

    private WinningLotto makeWinningLotto(){
        List<Integer> winningNumbers = inputDevice.inputWinningNumbers();
        Integer bonusNumber = inputDevice.inputBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
