package lotto.view;

import lotto.config.Rank;

import java.util.List;

public class OutputView {
    private static final String SHOW_LOTTO_CNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String SHOW_RATE_OF_RETURN_MESSAGE = "총 수익률은 %.2f%%입니다.\n";

    private OutputView() {
    }

    public static void showLottoCnt(int lottoCnt) {
        System.out.printf(SHOW_LOTTO_CNT_MESSAGE,lottoCnt);
    }

    public static void showLotto(List<List<Integer>> lotto) {
        for (List<Integer> eachLotto : lotto) {
            System.out.println(eachLotto);
        }
    }

    public static void showLottoWinningDetails(List<Integer> winningDetail) {
        Rank[] ranks = Rank.values();
        for (int i = 0; i < winningDetail.size(); i++) {
            System.out.println(ranks[i] + " - " + winningDetail.get(i));
        }
    }

    public static void showRateOfReturn(double rateOfReturn) {
        System.out.printf(SHOW_RATE_OF_RETURN_MESSAGE,rateOfReturn);
    }
}
