package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.controller.dto.LottoResult;

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

    public void printResult(final LottoResult lottoResult, final double revenue) {
        Map<String, Integer> rankCounts = lottoResult.getResult();
        rankCounts.forEach((key, value) -> System.out.println(key + " - " + value + "개"));
        System.out.println("총 수익률은 " + revenue + "%입니다.");
    }
}
