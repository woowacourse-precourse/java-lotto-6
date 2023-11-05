package lotto.controller;

import lotto.model.GetLottoPurchase;
import lotto.view.InputMessage;

public class LottoController {
    private static GetLottoPurchase getLottoPurchase;
    private boolean isGetCost = false;
    public LottoController(){
    }

    public void run(){
        start();
    }

    public void start(){
        int cost = purchaseAmount();

    }

    public int purchaseAmount(){
        while(!isGetCost){
            getLottoPurchase = new GetLottoPurchase(InputMessage.purchaseInput());
            if(getLottoPurchase.getGetCost() != 0)
                isGetCost = true;
        }
        return getLottoPurchase.getGetCost();
    }
}
