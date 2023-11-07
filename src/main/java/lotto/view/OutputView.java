package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    private static final String BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String REQUIRE_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";


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

    public static void printRequireMessage() {
        System.out.println(REQUIRE_WINNING_NUM_MESSAGE);
    }
}
