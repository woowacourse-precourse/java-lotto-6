package lotto.controller;

import lotto.service.LottoService;
import lotto.service.WinningStatisticsService;
import lotto.util.Parser;
import lotto.view.View;

public class LottoController {

    public void run() {
        LottoService lottoService = new LottoService();
        // 구입 금액 입력
        int purchasePrice = Parser.parsePurchasePrice(View.requestPurchasePrice());
        // 로또 번호 생성
        lottoService.setLottos(purchasePrice);
        // 로또 번호 출력
        View.responseLottoNumbers(lottoService.getLottos(), lottoService.getLottoCount());

        // 당첨 번호 입력
        String winningNumber = View.requestWinningNumber();
        // 보너스 번호 입력
        String bonusNumber = View.requestBonusNumber();

        // 당첨 통계 출력
        lottoService.setWinningLotto(Parser.parseLottoNumbers(winningNumber), Parser.parseBonusNumber(bonusNumber));
        WinningStatisticsService winningStatisticsService = new WinningStatisticsService(lottoService);
        winningStatisticsService.setWinningStatistics();
        View.responseWinningStatistics(winningStatisticsService.getWinningStatistics());

        // 총 수익률 출력
        double earningRate = winningStatisticsService.getEarningRate(purchasePrice);
        View.responseEarningRate(earningRate);
    }

}
