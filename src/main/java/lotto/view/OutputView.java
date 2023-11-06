package lotto.view;

import static lotto.enums.Prize.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningDetails;

public class OutputView {
    private static final String PURCHASE_LOTTO = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통게";
    private static final String DIVIDED_LINE = "---";
    private static final String MATCH_NUMBERS = "%d개 일치 (%s원) - %d개\n";
    private static final String MATCH_FIVE_NUMBERS_BONUS_NUMBERS = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    public static void purchaseLotto(int lottoCount){
        System.out.printf(PURCHASE_LOTTO,lottoCount);
    }

    public static void showEachLotto(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void showWinningDetails(WinningDetails winningDetails){
        int[] ranks = winningDetails.getRank();

        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDED_LINE);
        System.out.printf(MATCH_NUMBERS, FIFTH_RANK.getMatchNumbers(), FIFTH_RANK.getMoneyToString(), ranks[FIFTH_RANK.getRank()]);
        System.out.printf(MATCH_NUMBERS, FOURTH_RANK.getMatchNumbers(), FOURTH_RANK.getMoneyToString(), ranks[FOURTH_RANK.getRank()]);
        System.out.printf(MATCH_NUMBERS, THIRD_RANK.getMatchNumbers(), THIRD_RANK.getMoneyToString(), ranks[THIRD_RANK.getRank()]);
        System.out.printf(MATCH_FIVE_NUMBERS_BONUS_NUMBERS, SECOND_RANK.getMatchNumbers(), SECOND_RANK.getMoneyToString(), ranks[SECOND_RANK.getRank()]);
        System.out.printf(MATCH_NUMBERS, FIRST_RANK.getMatchNumbers(), FIRST_RANK.getMoneyToString(), ranks[FIRST_RANK.getRank()]);
    }

    public static void earningRate(float earningRate){
        System.out.printf(EARNING_RATE, earningRate);
    }
}
