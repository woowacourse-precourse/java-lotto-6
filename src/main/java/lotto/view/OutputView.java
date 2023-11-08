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
import lotto.model.constant.OutputMessage;
import lotto.util.WinningsGenerator;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final Map<Integer, String> winnings = WinningsGenerator.createWinnings();

    private OutputView() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static void printInputMoneyMessage() {
        System.out.println(OutputMessage.INPUT_MONEY);
    }

    public static void printLottoCount(LottoCount lottoCount) {
        System.out.printf(NEW_LINE);
        System.out.printf(OutputMessage.PURCHASED_LOTTO_COUNT.toString(), lottoCount.getLottoCount());
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
        System.out.println(OutputMessage.INPUT_WINNING_LOTTO_NUMBERS);
    }

    public static void printInputBonusNumberMessage() {
        System.out.printf(NEW_LINE);
        System.out.println(OutputMessage.INPUT_BONUS_NUMBER);
    }

    public static void printStatistic(Result result) {
        System.out.printf(NEW_LINE);
        System.out.println(OutputMessage.STATISTIC_HEADER);
        System.out.println(OutputMessage.STATISTIC_BORDER);

        for (Rank rank : Rank.getRankWithoutMiss()) {
            System.out.printf(OutputMessage.STATISTIC_BODY.toString(), rank.getMatchCount(), getMatchBonusBall(rank),
                    winnings.get(rank.getWinnings()), result.getRankCount(rank));
            System.out.printf(NEW_LINE);
        }
    }

    public static void printYield(Result result, Money money) {
        double winnings = result.getWinnings();
        double yield = (winnings / money.getMoney()) * LottoNumber.ONE_HUNDRED_PERCENT;
        System.out.printf(OutputMessage.TOTAL_YIELD.toString(), yield);
    }

    private static String getMatchBonusBall(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return OutputMessage.COMMA.toString() + OutputMessage.MATCH_BONUS_BALL;
        }
        return "";
    }
}
