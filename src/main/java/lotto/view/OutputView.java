package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void printBuyPrice() {
        System.out.println(BUY_PRICE_MESSAGE);
    }
    public static void printBuyAmount(int buyAmount){
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }


    public static void printUserLottos(List<Lotto> userLottos) {
        for (Lotto userLotto : userLottos) {
            System.out.println(userLotto.getNumbers());
        }
    }
}
