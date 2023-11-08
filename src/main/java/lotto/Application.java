package lotto;


import controller.Controller;
import domain.LottoResult;
import domain.WinningStatistics;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.run();
        //LottoCount lottoCount = new LottoCount(cnt);
        //lottoCount.printLottoCount();
        //lottoCount.printLotties();
        LottoResult lottoResult = new LottoResult();
        WinningStatistics winningStatistics = new WinningStatistics(
                lottoResult.getLottoResultNumber(),
                lottoCount.getLotties(),
                lottoResult.getBonusNumber(),
                display.getLottoPurchaseAmount());
    }
}
