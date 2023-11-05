package lotto.view;

import java.util.List;
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

    public static void printLottoNumber(List<List<Integer>> lottoAllNumbers) {
        for (List<Integer> lottoNumbers : lottoAllNumbers) {
            System.out.println(lottoNumbers);
        }
    }
}