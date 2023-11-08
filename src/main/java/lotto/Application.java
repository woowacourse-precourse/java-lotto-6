package lotto;

import lotto.controller.LottoController;
import lotto.controller.ReceiptController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = LottoController.getInstance();
        ReceiptController receiptController = ReceiptController.getInstance();

        lottoController.purchaseLotto();
        receiptController.showResult();
    }
}
