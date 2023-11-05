package lotto.controller;

import lotto.data.LottoRepository;
import lotto.data.PurchaseAmount;
import lotto.input.InputManager;
import lotto.output.ConsolePrinter;
import lotto.service.Service;

public class Controller {

    PurchaseAmount purchaseAmount;
    LottoRepository lottoRepository;

    public void inputPurchaseAmount(){

        ConsolePrinter.printPurchaseAmount();
        purchaseAmount =InputManager.inputPurchaseAmount();

    }

    public void outputPurchasedLotto() {

        ConsolePrinter.printPurchasedLottoCount(purchaseAmount);
        lottoRepository = Service.creatLottoRepository(purchaseAmount);
        ConsolePrinter.printLottoNumbers(lottoRepository);

    }
}
