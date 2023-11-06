package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.view.LottoView;

public class PurchaseController {
    private LottoView lottoView = new LottoView();

    public int runPurchaseAmount(){
        return processPurchaseAmount();
    }
    public int processPurchaseAmount(){
        String purchaseNum;
        int amount;
        while(true){
            try{
                purchaseNum = getPurchaseAmount();
                PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseNum);
                amount = purchaseAmount.getTicketNum();
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
