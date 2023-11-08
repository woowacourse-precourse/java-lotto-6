package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    private static final String BUY_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String REQUIRE_WINNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUIRE_BONUS_NUM_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String FIFTH_MESSAGE = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_MESSAGE = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String REVENUE_RATE_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void printBuyPrice() {
        System.out.println(BUY_PRICE_MESSAGE);
    }

    public static void printBuyAmount(int buyAmount) {
        System.out.println();
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }

    public static void printUserLottos(List<Lotto> userLottos) {
        for (Lotto userLotto : userLottos) {
            System.out.println(userLotto.getNumbers());
        }
    }

    public static void printRequireMessage() {
        System.out.println();
        System.out.println(REQUIRE_WINNING_NUM_MESSAGE);
    }

    public static void printRequireBonusMessage() {
        System.out.println();
        System.out.println(REQUIRE_BONUS_NUM_MESSAGE);
    }

    public static void printLottoResult(Map<Rank, Integer> lottoResult) {
        System.out.println();
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.printf(FIFTH_MESSAGE, lottoResult.get(Rank.Fifth));
        System.out.printf(FOURTH_MESSAGE, lottoResult.get(Rank.Fourth));
        System.out.printf(THIRD_MESSAGE, lottoResult.get(Rank.Third));
        System.out.printf(SECOND_MESSAGE, lottoResult.get(Rank.Second));
        System.out.printf(FIRST_MESSAGE, lottoResult.get(Rank.First));
    }

    public static void printRevenueRate(String revenueRate) {
        System.out.printf(REVENUE_RATE_MESSAGE, revenueRate);
    }

    public static void printErrorMessage(String e) {
        System.out.println(e);
    }
}
