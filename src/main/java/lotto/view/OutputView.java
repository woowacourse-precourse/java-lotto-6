package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.constant.LottoNumber;
import lotto.util.WinningsGenerator;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String STATISTIC_HEADER = "당첨 통계";
    private static final String STATISTIC_BORDER = "---";
    private static final String STATISTIC_BODY = "%d개 일치%s (%s원) - %d개";
    private static final String COMMA = ", ";
    private static final String MATCH_BONUS_BALL = "보너스 볼 일치";
    private static final String TOTAL_YIELD = "총 수익률은 %.1f%%입니다.";
    private static final Map<Integer, String> winnings = WinningsGenerator.createWinnings();

    private OutputView() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static void printInputMoneyMessage() {
        System.out.println(INPUT_MONEY);
    }

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.printf(NEW_LINE);
        System.out.printf(PURCHASED_LOTTO_COUNT, lottoCount.getLottoCount());
        System.out.printf(NEW_LINE);
    }

    public static void printPurchasedLotto(Lottos lottos) {
        for (Lotto lotto : lottos.get()) {
            List<Integer> numbers = new ArrayList<>(lotto.get());
            Collections.sort(numbers);
            System.out.println(numbers);
        }
        System.out.printf(NEW_LINE);
    }

    public static void printInputWinningLottoNumbersMessage() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS);
    }

    public static void printInputBonusNumberMessage() {
        System.out.printf(NEW_LINE);
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printStatistic(Result result) {
        System.out.printf(NEW_LINE);
        System.out.println(STATISTIC_HEADER);
        System.out.println(STATISTIC_BORDER);

        for (Rank rank : Rank.getRankWithoutMiss()) {
            System.out.printf(STATISTIC_BODY, rank.getMatchCount(), getMatchBonusBall(rank),
                    winnings.get(rank.getWinnings()), result.getRankCount(rank));
            System.out.printf(NEW_LINE);
        }
    }

    public static void printYield(Result result, Money money) {
        double winnings = result.getWinnings();
        double yield = (winnings / money.getMoney()) * LottoNumber.ONE_HUNDRED_PERCENT;
        System.out.printf(TOTAL_YIELD, yield);
    }

    private static String getMatchBonusBall(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return COMMA + MATCH_BONUS_BALL;
        }
        return "";
    }
}
