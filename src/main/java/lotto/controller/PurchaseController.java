package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.view.LottoView;

public class PurchaseController {

    private LottoView lottoView = new LottoView();

    public PurchaseAmount runPurchaseAmount(){
        return processPurchaseAmount();
    }

    public PurchaseAmount processPurchaseAmount(){
        String purchaseNum;
        PurchaseAmount amount;
        while(true){
            try{
                purchaseNum = getPurchaseAmount();
                PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseNum);
                amount = purchaseAmount;
                break;
            }catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    public String getPurchaseAmount(){
        String purchaseNum;

        lottoView.inputPurchaseAmountView();
        purchaseNum = Console.readLine();

        return purchaseNum;
    }
}
