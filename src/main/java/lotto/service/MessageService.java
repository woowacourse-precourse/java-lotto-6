package lotto.service;

import lotto.constant.InputMessage;
import lotto.constant.OutputMessage;

public class MessageService {
    public void inputPurchasePrice(){
        System.out.println(InputMessage.INPUT_PURCHASE_PRICE.getMessage());
    }

    public void outputPurchaseAmount(int purchaseAmount){
        System.out.println();
        System.out.println(purchaseAmount + OutputMessage.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage());
    }
}
