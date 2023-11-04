package lotto.controller;

import lotto.model.LottoService;
import lotto.model.dto.PayDTO;
import lotto.view.BeforeScreen;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        int numberOfLotto = readPayment();
        this.lottoService = new LottoService(numberOfLotto);
        printPurchasedLottos(numberOfLotto);
    }

    private void printPurchasedLottos(int numberOfLotto) {
        String resultOfPurchasedLottos = lottoService.printPurchasedLottos();
        BeforeScreen.printPurchasedLottos(numberOfLotto, resultOfPurchasedLottos);
    }

    public int readPayment(){
        PayDTO pay = BeforeScreen.readPayment();
        return pay.getNumberOfLotto();
    }
}
