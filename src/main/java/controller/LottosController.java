package controller;

import domain.PurchaseAmount;
import domain.Lottos;
import dto.LottoDto;
import service.LottosService;
import service.PurchaseService;
import view.InputView;
import view.OutputView;

import java.util.List;

import static view.InputView.inputWinnging;

public class LottosController {
    private final LottosService lottosService;

    public LottosController(){
        lottosService = new LottosService();
    }

    public void start(final PurchaseAmount purchaseAmount){
        Lottos purchaseLottos = generateLottos(purchaseAmount);
        printPurchaseLottos(purchaseLottos, purchaseAmount.getQuantity());
        generateWinngingAndBonus();
    }

    private Lottos generateLottos(final PurchaseAmount purchaseAmount){
        return lottosService.createLottos(purchaseAmount);
    }

    private void printPurchaseLottos(final Lottos purchaseLottos, final int numberOfPurchased){
        List<LottoDto> printPurchaseLottos = lottosService.getPurchaseLottos(purchaseLottos);
        OutputView.printPurchaseLottos(printPurchaseLottos, numberOfPurchased);
    }

    private void generateWinngingAndBonus(){
        String winngNumbers = inputWinnging();
    }
}
