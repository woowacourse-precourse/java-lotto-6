package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.utils.Parser;
import lotto.view.LottoView;

public class PurchaseController {
    private LottoView lottoView = new LottoView();
    public void processPurchaseAmount(){
        String purchaseNum;
        while(true){
            try{
                purchaseNum = getPurchaseAmount();
                PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseNum);
                break;
            }catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }
    public String getPurchaseAmount(){
        String purchaseNum;

        lottoView.purchaseAmountView();
        purchaseNum = Console.readLine();

        return purchaseNum;
    }

}
