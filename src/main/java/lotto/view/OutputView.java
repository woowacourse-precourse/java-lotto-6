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
        println("");
    }

    public void notifyInputAmount() {
        println("구입금액을 입력해 주세요.");
    }

    public void notifyInputWinningNumbers() {
        println("당첨 번호를 입력해 주세요.");
    }

    public void notifyInputBonusNumber() {
        println("보너스 번호를 입력해 주세요.");
    }

    public void printWinningStats(WinningStats winningStats) {
        println("당첨 통계");
        println("---");
        winningStats.winningMessages().forEach(this::println);
    }

    public void printEarningRate(WinningStats winningStats, int amount) {
        double earningRate = (double) winningStats.winningPrize() / amount * 100;
        StringBuilder sb = new StringBuilder();
        sb.append("총 수익률은 ");
        sb.append(String.format("%.1f", earningRate));
        sb.append("%입니다.");
        println(sb.toString());
    }
}
