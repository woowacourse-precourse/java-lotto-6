package lotto.view;

import lotto.utils.constants.Comment;

public class OutputView {

    public static void printGameStartMessage() {
        System.out.println(Comment.INPUT_PURCHASE_AMOUNT.getComment());
        InputView.inputPurchaseAmount();
    }
}
