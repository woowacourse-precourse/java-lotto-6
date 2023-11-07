package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Game;
import lotto.model.LottoRankInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private Game game;
    private int buyAmount;

    public LottoGameController(Game game) {
        this.game = game;
    }


    public void start() {
        getBuyAmount();
        createLottos();
        printResult(createResult(getWinningNumbers(), getBonusNumber()));
    }

    private void getBuyAmount() {
        OutputView.printRequestBuyAmount();
        getBuyAmountValidationLoop();
        OutputView.printBuyCount(buyAmount);
    }

    private void getBuyAmountValidationLoop() {
        while (true) {
            try {
                buyAmount = Integer.parseInt(InputView.readBuyAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void createLottos() {
        OutputView.printCreatedLottos(game.createLottos(buyAmount));
    }

    private List<Integer> getWinningNumbers() {
        OutputView.printRequestWinningNumber();
        String[] numbers = InputView.readWinningNumber().split(",");
        return Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int getBonusNumber() {
        OutputView.printRequestBonusNumber();
        return Integer.parseInt(InputView.readBonusNumber());
    }

    private LottoRankInfo createResult(List<Integer> winningNumbers, int bonusNumber) {
        return game.createResult(winningNumbers, bonusNumber);
    }

    private void printResult(LottoRankInfo lottoRankInfo) {
        printRank(lottoRankInfo);
        printProfit(lottoRankInfo);
    }

    private void printRank(LottoRankInfo lottoRankInfo) {
        OutputView.printStartResult();
        OutputView.printWinningResult(lottoRankInfo.getLottoRankInfo());
    }

    private void printProfit(LottoRankInfo lottoRankInfo) {
        OutputView.printProfitRate(game.createProfit(buyAmount, lottoRankInfo.getLottoRankInfo()));
    }


}
