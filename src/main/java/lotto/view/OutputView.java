package lotto.view;

import lotto.utils.Message;

public class OutputView {
    private OutputView() {
    }

    public static void printBuyInputPrice() {
        System.out.println(Message.PRINT_USER_INPUT_BUY_PRICE.getMessage());
    }

    public static void printBuyLottoCount(int count) {
        System.out.println();
        System.out.println(count + Message.PRINT_USER_BUY_LOTTO_COUNT.getMessage());
        System.out.println();
    }

    public static void printEntertWinningNumber(){
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_WINNING_NUMBER.getMessage());
    }

    public static void printEnterBounsNumber(){
        System.out.println();
        System.out.println(Message.PRINT_USER_ENTER_BONUS_NUMBER.getMessage());
    }


}
