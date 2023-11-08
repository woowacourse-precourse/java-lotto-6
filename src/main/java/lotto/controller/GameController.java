package lotto.controller;


import static lotto.domain.GameResult.createGameResult;
import static lotto.domain.LottoWinningCombination.createLottoWinningCombination;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoWinningCombination;
import lotto.handler.InputHandler;
import lotto.handler.OutputHandler;
import lotto.service.LottoService;
import lotto.view.OutputView;

public class GameController {
    private GameController() {
    }

    public static void game() {
        long lottoPurchasePrice = InputHandler.setLottoPurchasePrice();

        List<Lotto> lottos = setLottos(lottoPurchasePrice);

        LottoWinningCombination lottoWinningCombination = setWinningCombination();

        finalLottoGame(lottos, lottoWinningCombination, lottoPurchasePrice);

    }

    private static List<Lotto> setLottos(long lottoPurchasePrice) {
        List<Lotto> lottos = LottoService.issueLottoTickets(lottoPurchasePrice);
        OutputHandler.outputLottosInfo(lottos);
        return lottos;
    }

    private static LottoWinningCombination setWinningCombination() {
        List<Integer> winnerNums = InputHandler.setWinningNums();
        OutputView.printMessageBlankLine();

        int bonusNum = InputHandler.setBonusNum(winnerNums);
        OutputView.printMessageBlankLine();

        return createLottoWinningCombination(winnerNums, bonusNum);
    }

    private static void finalLottoGame(List<Lotto> lottos, LottoWinningCombination lottoWinningCombination,
                                       long lottoPurchasePrice) {
        List<LottoResult> lottoResults = LottoService.determineLottoResults(lottos, lottoWinningCombination);

        GameResult gameResult = createGameResult(lottoResults, lottoPurchasePrice);
        OutputHandler.outputGameResult(gameResult);
        OutputHandler.outputRateOfReturn(gameResult);
    }

}
