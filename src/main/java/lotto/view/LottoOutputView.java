package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoOutputView {
    private static final String USER_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String USER_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String USER_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String PURCHASE_AMOUNT_COUNT = "\n%d개를 구매했습니다.";
    private static final String LOTTO_RESULT = "당첨 통계";
    private static final String DASH = "-";
    private static final String RESULT_TEMPLATE = "%d개 일치 (%d원) - %d개";
    private static final String REVENUE_TEMPLATE = "총 수익률은 %f입니다.";

    public void printUserInputPurchaseAmount() {
        System.out.println(USER_INPUT_PURCHASE_AMOUNT);
    }

    public void printUserInputWinningNumber() {
        System.out.println(USER_INPUT_WINNING_NUMBER);
    }

    public void printPurchaseAmountCount(final int purchaseAmount) {
        System.out.println(String.format(PURCHASE_AMOUNT_COUNT, purchaseAmount / 1000));
    }

    public void printUserInputBonusNumber() {
        System.out.println(USER_INPUT_BONUS_NUMBER);
    }

    public void printLottos(final List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        System.out.println(sb);
    }
}
