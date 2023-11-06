package controller;

import domain.Lotto;
import domain.PurchaseAmount;
import domain.PurchaseLottos;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * packageName    : controller
 * fileName       : LottoController
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class LottoController {

    private static int amount;
    private static List<Lotto> lotto;
    public void playLotto(){
        try {
            purchaseLotto();
        } catch(NumberFormatException e){

        } catch(IllegalArgumentException e){

        }
    }

    private void purchaseLotto(){
        PurchaseAmount purchaseAmount = setPurchaseAmount();
        int numberOfLottosPurchased = purchaseAmount.getNumberOfLottoPurchased();
        amount = purchaseAmount.getAmount();
        PurchaseLottos purchaseLottos = setPurchaseLottos(numberOfLottosPurchased);
        lotto = purchaseLottos.getPurchaseLottos();
        printInfo(lotto, numberOfLottosPurchased);
    }

    private PurchaseAmount setPurchaseAmount(){
        return new PurchaseAmount(InputView.enterAmount());
    }

    private PurchaseLottos setPurchaseLottos(int numberOfLottosPurchased){
        return new PurchaseLottos(numberOfLottosPurchased);
    }

    private void printInfo(List<Lotto> lotto, int numberOfLottosPurchased){
        OutputView.printNumberOfLottosPurchased(numberOfLottosPurchased);
        OutputView.printLottos(lotto);
    }
}
