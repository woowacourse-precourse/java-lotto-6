package controller;

import domain.BonusNumber;
import domain.PurchaseAmount;
import domain.Lottos;
import domain.WinningNumbers;
import dto.LottoDto;
import service.LottosService;
import service.PurchaseService;
import view.InputView;
import view.OutputView;

import java.util.List;

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
        WinningNumbers winningNumbers = generateWinngingNumbers();
        BonusNumber bonusNumber = generateBonusNumber();
    }

    private WinningNumbers generateWinngingNumbers(){
        try{
            List<Integer> winningNumbers = InputView.inputWinngingNumbers();
            return createWinngingNumbers(winningNumbers);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return generateWinngingNumbers();
        }
    }

    private BonusNumber generateBonusNumber(){
        try{
            int number = InputView.inputBonusNumber();
            return createBonusNumber(number);
        } catch (IllegalArgumentException e){
            OutputView.printMessage(e.getMessage());
            return generateBonusNumber();
        }
    }

    private WinningNumbers createWinngingNumbers(final List<Integer> winningNumbers){
        return lottosService.createWinningNumbers(winningNumbers);
    }

    private BonusNumber createBonusNumber(final int bonusNumber){
        return lottosService.createBonusNumber(bonusNumber);
    }
}
