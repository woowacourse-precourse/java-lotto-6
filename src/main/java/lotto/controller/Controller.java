package lotto.controller;

import lotto.data.BonusNumber;
import lotto.data.LottoRepository;
import lotto.data.PurchaseAmount;
import lotto.data.WinningNumbers;
import lotto.input.InputManager;
import lotto.output.ConsolePrinter;
import lotto.service.Service;

public class Controller {

    PurchaseAmount purchaseAmount;
    LottoRepository lottoRepository;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;

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
}
