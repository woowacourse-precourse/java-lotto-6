package controller;

import domain.*;
import dto.LottoDto;
import service.LottosService;
import service.PurchaseService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottosController {
    private final LottosService lottosService;
    private Lottos lottos;

    public LottosController(){
        lottosService = new LottosService();
    }

    public Lottos start(final PurchaseAmount purchaseAmount){
        Lottos purchaseLottos = generateLottos(purchaseAmount);
        lottos = purchaseLottos;
        printPurchaseLottos(purchaseLottos, purchaseAmount.getQuantity());
        return lottos;
    }

    private Lottos generateLottos(final PurchaseAmount purchaseAmount){
        return lottosService.createLottos(purchaseAmount);
    }

    private void printPurchaseLottos(final Lottos purchaseLottos, final int numberOfPurchased){
        List<LottoDto> printPurchaseLottos = lottosService.getPurchaseLottos(purchaseLottos);
        OutputView.printPurchaseLottos(printPurchaseLottos, numberOfPurchased);
    }
}
