package lotto.view;

import lotto.util.OutPutMessage;

public class OutputView {
    public void printChances(int chance){
        System.out.println(String.valueOf(chance)+OutPutMessage.OUTPUT_MONEY_MESSAGE);
    }
}
