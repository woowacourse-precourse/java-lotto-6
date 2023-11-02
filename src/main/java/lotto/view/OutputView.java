package lotto.view;

import lotto.utils.Message;

public class OutputView {
    private OutputView() {
    }

    public static void printBuyInputPrice(){
        System.out.println(Message.PRINT_USER_INPUT_BUY_PRICE.getMessage());
    }

}
