package lotto;


import view.Display;
import view.LottoCount;
import view.LottoResult;
import view.WinningStatistics;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Display display = new Display();
        int cnt = display.getLottoPurchaseAmount();
        LottoCount lottoCount = new LottoCount(cnt);
        lottoCount.printLottoCount();
        lottoCount.printLotties();
        LottoResult lottoResult = new LottoResult();
        WinningStatistics winningStatistics = new WinningStatistics(
                lottoResult.getLottoResultNumber(),
                lottoCount.getLotties());
    }
}
