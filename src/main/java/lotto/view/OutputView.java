package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningRank;
import lotto.model.WinningStats;

import java.util.ArrayList;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void println(String message) {
        System.out.println(message);
    }


    public void printLottoCount(int count) {
        println(count + "개를 구매했습니다.");
    }

    public void printLottoNumbers(ArrayList<Lotto> lottoBundle) {
        lottoBundle.forEach(lotto -> println(lotto.toString()));
    }

    public void notifyInputAmount() {
        println("구입금액을 입력해 주세요.");
    }

    public void printWinningStats(WinningStats winningStats) {
        winningStats.winningMessages().forEach(this::println);
    }

    public void printEarningRate(WinningStats winningStats, int amount) {
        float earningRate = (float) winningStats.winningPrize() / amount * 100;
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ");
        sb.append(String.format("%.3f", earningRate));
        sb.append("%입니다.");
        println(sb.toString());
    }
}
