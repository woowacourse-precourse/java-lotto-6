package lotto;

import java.util.ArrayList;

public class LottoController {
    public static void start() {
        Lottos lottos = purchaseLotto();
    }

    private static Lottos purchaseLotto() {
        /* 구입금액 입력 및 구매*/
        String requestPurchasePrice = LottoView.requestPurchasePrice();
        int purchasePrice = LottoParser.readLineToNumber(requestPurchasePrice);
        LottoInputValidator.purchasePriceIsValid(purchasePrice);
        Lottos lottos = new Lottos(purchasePrice / LottoConstants.LOTTO_PRICE.getConstant());


        /* 로또 구매갯수 및 번호들 출력*/
        LottoView.printPurchasedLottos(lottos);
        return lottos;
    }
}
