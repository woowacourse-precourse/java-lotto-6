package lotto.controller;

import lotto.data.*;
import lotto.input.InputManager;
import lotto.output.ConsolePrinter;
import lotto.service.Service;

public class Controller {

    PurchaseAmount purchaseAmount;
    LottoRepository lottoRepository;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    LottoResult lottoResult;

    public void inputPurchaseAmount(){

        ConsolePrinter.printPurchaseAmount();
        purchaseAmount =InputManager.inputPurchaseAmount();

    }

    public void outputPurchasedLotto() {

        ConsolePrinter.printPurchasedLottoCount(purchaseAmount);
        lottoRepository = Service.creatLottoRepository(purchaseAmount);
        ConsolePrinter.printLottoNumbers(lottoRepository);

    }

    public void inputWinningNumbers() {

        ConsolePrinter.printRequestWinningNumbers();
        winningNumbers = InputManager.inputWinningNumbers();

    }

    public void inputBonusNumber() {

        ConsolePrinter.printRequestBonusNumber();
        bonusNumber = InputManager.inputBonusNumber(winningNumbers);
    }

    public void outputLottoResult() {

        lottoResult = Service.createLottoResult(lottoRepository,winningNumbers,bonusNumber);
        ConsolePrinter.printLottoResult(lottoResult);

    }

    public void outputRateOfReturn() {

        double rateOfReturn = Service.calculateRateOfReturn(lottoResult,purchaseAmount);

        if(rateOfReturn<=0) rateOfReturn+=100;
        ConsolePrinter.printRateOfReturn(rateOfReturn);





        //수익률은 (얻은 상금 - 투자 금액) / 투자 금액
        // 상금 - 구입금액 / 구입금액 40000/500004/5//// 5000-8000/8000==3/8
    }
}
