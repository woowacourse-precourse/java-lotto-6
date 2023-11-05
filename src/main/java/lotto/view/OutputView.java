package lotto.view;

import lotto.service.LottoService;
import lotto.utils.constants.Comment;

public class OutputView {

    public static void printGameStartMessage() {
        System.out.println(Comment.INPUT_PURCHASE_AMOUNT.getComment());
    }

    public static void printLottoPurchaseAmount(int lottoNumber) {
        LottoService.amountPurchaseDivide(lottoNumber);
        System.out.println();
        System.out.println(lottoNumber + Comment.OUTPUT_PURCHASE_AMOUNT.getComment());
    }
}
