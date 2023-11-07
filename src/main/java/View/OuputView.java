package View;

import java.util.List;
import lotto.Lotto;
import lotto.WinningResults;

public class OuputView {
    public void printUserLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers().stream().sorted()));
    }

    public void printWinningResults(WinningResults winningResults) {
        printWinningHistory();
        printWinningRate(winningResults.getWinningRate());
    }

    private void printWinningHistory() {

    }

    private void printWinningRate(float winningRate) {
        System.out.println("총 수익률은 " + winningRate + "입니다.");
    }
}
