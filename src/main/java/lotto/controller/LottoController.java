package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.WinningStatisticsService;
import lotto.util.Parser;
import lotto.view.View;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    private int purchasePrice = 0;

    public void run() {
        initLotto();
        initWinningLotto();
        projectStatistics();
    }

    private void initLotto() {
        // 구입 금액 입력
        purchasePrice = validateInputUntilSuccess(View::requestPurchasePrice, Parser::parsePurchasePrice);
        // 로또 번호 생성
        lottoService.setLottos(purchasePrice);
        // 로또 번호 출력
        View.responseLottoNumbers(lottoService.getLottos(), lottoService.getLottoCount());
    }

    private void initWinningLotto() {
        // 당첨 번호 입력
        Lotto winningLotto = validateInputUntilSuccess(View::requestWinningNumber, Parser::parseLottoNumbers);
        // 보너스 번호 입력
        int bonusNumber = validateInputUntilSuccess(View::requestBonusNumber, Parser::parseBonusNumber);
        // 당첨 번호, 보너스 번호 설정
        lottoService.setWinningLotto(winningLotto, bonusNumber);
    }

    private void projectStatistics() {
        // 당첨 통계 출력
        WinningStatisticsService winningStatisticsService = new WinningStatisticsService(lottoService);
        winningStatisticsService.setWinningStatistics();
        View.responseWinningStatistics(winningStatisticsService.getWinningStatistics());

        // 총 수익률 출력
        double earningRate = winningStatisticsService.getEarningRate(purchasePrice);
        View.responseEarningRate(earningRate);
    }

    private <T> T validateInputUntilSuccess(Supplier<String> request, ParserFunction<String, T> parser) {
        T result = null;
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                result = parser.apply(request.get());
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                View.responseErrorMessage(e.getMessage());
            }
        }
        return result;
    }

    @FunctionalInterface
    interface ParserFunction<T, R> {
        R apply(T t) throws IllegalArgumentException;
    }

}
