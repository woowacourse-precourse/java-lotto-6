package lotto.view;

import lotto.ResultBuilder;

import java.util.List;

public class OutputView {
    private static final String BUY_LOTTO_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_LOTTO_MESSAGE = "당첨 통계\n---";
    private static final String FRONT_EARNING_RATE_MESSAGE = "총 수익률은 ";
    private static final String BACK_EARNING_RATE_MESSAGE = "%입니다.";

    public void readBuyLottoMessage(int quantity) {
        System.out.println(quantity + BUY_LOTTO_MESSAGE);
    }

    public void readWinningLottoMessage() {
        System.out.println(WINNING_LOTTO_MESSAGE);
    }

    public void readLottoNumbers(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void readWinningLottoResult(int[] result) {
        ResultBuilder resultBuilder = new ResultBuilder();
        System.out.println(resultBuilder.resultBuild(result));
    }

    public void readEarningRate(int inputMoney, long totalEarnings) {
        double percent = (double) totalEarnings / (double) inputMoney * 100.0;
        System.out.println(FRONT_EARNING_RATE_MESSAGE + String.format("%.1f", percent) + BACK_EARNING_RATE_MESSAGE);
    }
}
