package controller;

import domain.PurchaseAmount;
import domain.Lottos;
import dto.LottoDto;
import service.LottosService;
import service.PurchaseService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottosController {
    private final PurchaseService purchaseService;
    private final LottosService lottosService;

    public LottosController(){
        purchaseService = new PurchaseService();
        lottosService = new LottosService();
    }

    public void start(){
        PurchaseAmount purchaseAmount = generatePurchaseAmount();
        Lottos purchaseLottos = generateLottos(purchaseAmount);
        printPurchaseLottos(purchaseLottos, purchaseAmount.getQuantity());
    }

    private PurchaseAmount generatePurchaseAmount(){
        String purchaseAmount = InputView.inputPurchaseAmount();
        try{
            return createPurchaseAmount(purchaseAmount);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return generatePurchaseAmount();
        }
    }

    private PurchaseAmount createPurchaseAmount(final String purchaseAmount){
        return purchaseService.createPurchaseAmount(purchaseAmount);
    }

    private Lottos generateLottos(final PurchaseAmount purchaseAmount){
        return lottosService.createLottos(purchaseAmount);
    }

    private void printPurchaseLottos(final Lottos purchaseLottos, final int numberOfPurchased){
        List<LottoDto> printPurchaseLottos = lottosService.getPurchaseLottos(purchaseLottos);
        OutputView.printPurchaseLottos(printPurchaseLottos, numberOfPurchased);
    }
}
