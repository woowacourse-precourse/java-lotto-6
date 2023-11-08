package lotto.view;

import lotto.domain.LottoRanking;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class OutputView {
    private static final String LOTTO_BAY_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_WINNING_MESSAGE = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String WINNING_COUNT_MESSAGE = "%d개 일치 (%s) - %d개\n";
    private static final String WINNING_COUNT_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s) - %d개\n";
    private static final String TOTAL_PRIZE_MONEY_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String THREE_PRIZE_MONEY = "5,000원";
    private static final String FOUR_PRIZE_MONEY = "50,000원";
    private static final String FIVE_PRIZE_MONEY = "1,500,000원";
    private static final String FIVE_AND_BONUS_PRIZE_MONEY = "30,000,000원";
    private static final String SIX_PRIZE_MONEY = "2,000,000,000원";
    private static final String NEW_LINE = "\n";

    public static void showBayLottoCount(int lottoCount) {
        System.out.println(String.format(LOTTO_BAY_COUNT_MESSAGE, lottoCount));
    }


    public static void showBayLottoNumber(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.print(NEW_LINE);
    }

}