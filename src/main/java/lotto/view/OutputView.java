package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.RankTable;
import lotto.util.LottoTypeConverter;

import java.util.List;

public class OutputView {
    public static final String BUY_PRICE = "구입금액을 입력해 주세요.";
    public static final String BOUGHT_LOTTO_NUMBER = "개를 구매했습니다.";
    public static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "당첨 통계\n---";
    public static final String BONUS = ", 보너스 볼 일치";
    public static final String PREFIX_RATE_RETURN = "총 수익률은 ";
    public static final String SUFFIX_RATE_RETURN = "%입니다.";

    public static void askBuyLottoPrice() {
        System.out.println(BUY_PRICE);
    }

    public static void boughtLottoNumber(int boughtLottoNumber, List<Lotto> boughtLottos) {
        nextLine();
        System.out.println(boughtLottoNumber + BOUGHT_LOTTO_NUMBER);
        boughtLottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void askWriteWinningNumber() {
        nextLine();
        System.out.println(WINNING_NUMBER);
    }

    public static void askWriteBonusNumber() {
        nextLine();
        System.out.println(BONUS_NUMBER);
    }

    public static void winningStatistics(List<RankTable> matchLottoCalculate) {
        System.out.println(WINNING_STATISTICS);
        for (RankTable value : RankTable.values()) {
            int matchNumber = value.getMatchNumber();

            System.out.print(matchNumber + "개 일치");
            if (value.isBonus()) {
                System.out.print(BONUS);
            }
            System.out.print(LottoTypeConverter.toWon(value.getMoney()) + " - ");

            String count = count(value, matchLottoCalculate);
            System.out.println(count);
        }
    }

    private static String count(RankTable value, List<RankTable> matchLottoCalculate) {
        int count = 0;
        for (RankTable rankTable : matchLottoCalculate) {
            if (rankTable == value) {
                ++count;
            }
        }
        return count + "개";
    }

    public static void income(double statistic) {
        System.out.print(PREFIX_RATE_RETURN + statistic + SUFFIX_RATE_RETURN);
    }

    public static void nextLine() {
        System.out.println();
    }
}
