package lotto.view;

import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.domain.User;
import lotto.domain.Lotto;
public class OutputView {
    public static final String AMOUNT_OF_LOTTO = "개를 구매하였습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String DIVIDER_LINE = "---";
    public static final String PROFIT_ANNOUNCEMENT = "총 수익률은 ";
    public static final String PROFIT_ANNOUNCEMENT_CLOSING = "%입니다.";


    public static void printUserLotto(User user) {
        System.out.println(user.getAmount()+AMOUNT_OF_LOTTO);
        for (Lotto lotto: user.getLottos()) {
            System.out.println(lotto.toString());
        }
    }
    public static void printResult(Result result) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDER_LINE);
        for(Rank currentrank : Rank.values()) {
            int count = result.getResults().stream()
                    .filter(rank -> rank == currentrank)
                    .mapToInt(rank -> 1)
                    .sum();
            int awardMoney = currentrank.getAwardMoney();
            String message = currentrank.getMessage();

            System.out.println(count + "개 일치 (" + awardMoney + "원) - " + message);
        }

    }
    public static void printProfitRate(long value) {
        System.out.println(PROFIT_ANNOUNCEMENT+Math.round(value*100.0)/100.0+PROFIT_ANNOUNCEMENT_CLOSING);
    }
}
