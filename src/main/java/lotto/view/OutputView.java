package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASE_PROMPT_MESSAGE = "구입금액을 입력해 주세요.";

    public void printPurchaseMessage() {
        System.out.println(PURCHASE_PROMPT_MESSAGE);
    }

    public void printBuyLotto(final int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLotto(final List<Integer> lotto){
        System.out.println(lotto);
    }
}
