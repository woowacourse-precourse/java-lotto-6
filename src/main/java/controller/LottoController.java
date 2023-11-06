package controller;

import domain.PurchaseAmount;
import domain.PurchaseLottos;
import view.InputView;

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
        setPurchaseLottos(numberOfLottosPurchased);
    }

    private void setPurchaseLottos(int numberOfLottosPurchased){
        new PurchaseLottos(numberOfLottosPurchased);
    }

    private PurchaseAmount setPurchaseAmount(){
        return new PurchaseAmount(InputView.enterAmount());
    }
}
