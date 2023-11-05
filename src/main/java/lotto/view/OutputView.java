package lotto.view;

import lotto.message.RunMessage;

public class OutputView {
    public void printAmountInputMessage(){
        System.out.print(RunMessage.INPUT_AMOUNT_MESSAGE.getMessage());
    }

    public void printBuyLottoMessage(int lottoCount){
        System.out.printf(RunMessage.PRINT_LOTTO_COUNT.getMessage(),lottoCount);
    }
    
}
