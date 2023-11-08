package lotto.controller;

import lotto.model.Player;
import lotto.model.WinningDetail;
import lotto.model.WinningNumbers;
import lotto.service.LottoGameService;
import lotto.util.RandomUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final LottoGameService lottoGameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final RandomUtil randomUtil;

    public LottoGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        randomUtil = new RandomUtil();
        lottoGameService = new LottoGameService(inputView, outputView, randomUtil);
    }

    public void startGame() {
        final Player player = lottoGameService.createPlayer();
        outputView.printLottoInfo(player.getLottos());
        outputView.printLineOfSpace();
        WinningNumbers winningNumbers = lottoGameService.createWinningNumber();
        WinningDetail winningDetail = new WinningDetail(player.getLottos(), winningNumbers);
        outputView.printWinningDetail(winningDetail.getWinningCount());
        outputView.printProfitRate(player.calculateProfitRate(winningNumbers));
    }
}