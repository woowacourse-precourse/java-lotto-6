package lotto.controller;

import lotto.model.Purchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private Integer purchaseAmount;
    public LottoController(){

    }

    public void buyLotto(){
        while(true){
            try{
                String priceNumber = InputView.inputString(ViewMessage.SetPurchaseMoney.getMessage());
                Purchase purchasePrice = new Purchase(priceNumber);
                purchaseAmount = purchasePrice.getPurchaseAmount();

                break;
            } catch(IllegalArgumentException e){
                OutputView.ErrorView(ViewMessage.ErrorInvaildPrice.getMessage());
            }
        }
    }
}
