package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningDetails;

public class OutputView {
    private static final String PURCHASE_LOTTO = "%s개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "당첨 통게";
    private static final String DIVIDED_LINE = "---";
    private static final String MATCH_NUMBERS = "%s개 일치 (%s원) - %d개\n";
    private static final String MATCH_FIVE_NUMBERS_BONUS_NUMBERS = "%s개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    private static final String FIFTH_PLACE_MONEY = "5,000";
    private static final String FOURTH_PLACE_MONEY = "50,000";
    private static final String THIRD_PLACE_MONEY = "1,500,000";
    private static final String SECOND_PLACE_MONEY = "30,000,000";
    private static final String FIRST_PLACE_MONEY = "2,000,000,000";

    private static final String FIFTH_PLACE_MATCH_NUMBERS = "3";
    private static final String FOURTH_PLACE_MATCH_NUMBERS = "4";
    private static final String THIRD_PLACE_MATCH_NUMBERS = "5";
    private static final String SECOND_PLACE_MATCH_NUMBERS = "5";
    private static final String FIRST_PLACE_MATCH_NUMBERS = "6";

    private static final int RANK_FIVE = 5;
    private static final int RANK_FOUR = 4;
    private static final int RANK_THREE = 3;
    private static final int RANK_TWO = 2;
    private static final int RANK_ONE = 1;


    public static void purchaseLotto(int lottoCount){
        System.out.printf(PURCHASE_LOTTO,lottoCount);
    }

    public static void showEachLotto(List<Lotto> lottos) {
        for(Lotto lotto : lottos){
            System.out.println(lotto.getValue());
        }
    }

    public static void showWinningDetails(WinningDetails winningDetails){
        int[] ranks = winningDetails.getRank();

        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDED_LINE);
        System.out.printf(MATCH_NUMBERS, FIFTH_PLACE_MATCH_NUMBERS, FIFTH_PLACE_MONEY, ranks[RANK_FIVE]);
        System.out.printf(MATCH_NUMBERS, FOURTH_PLACE_MATCH_NUMBERS, FOURTH_PLACE_MONEY, ranks[RANK_FOUR]);
        System.out.printf(MATCH_NUMBERS, THIRD_PLACE_MATCH_NUMBERS, THIRD_PLACE_MONEY, ranks[RANK_THREE]);
        System.out.printf(MATCH_FIVE_NUMBERS_BONUS_NUMBERS, SECOND_PLACE_MATCH_NUMBERS, SECOND_PLACE_MONEY, ranks[RANK_TWO]);
        System.out.printf(MATCH_NUMBERS, FIRST_PLACE_MATCH_NUMBERS, FIRST_PLACE_MONEY, ranks[RANK_ONE]);
    }

    public static void earningRate(float earningRate){
        System.out.printf(EARNING_RATE, earningRate);
    }
}
