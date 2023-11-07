package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Game;
import lotto.model.LottoChecker;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private Game game;
    private int buyAmount = 0;
    private List<Integer> winningNumbers;
    private int bonusNumber = 0;

    public LottoGameController(Game game) {
        this.game = game;
    }


    public void start() {
        getBuyAmount();
        createLottos();
        getWinningNumbers();
        getBonusNumber();
        printResult(createResult());
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

    private void getWinningNumbers() {
        OutputView.printRequestWinningNumber();
        String[] numbers = InputView.readWinningNumber().split(",");
        winningNumbers = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void getBonusNumber() {
        OutputView.printRequestBonusNumber();
        bonusNumber = Integer.parseInt(InputView.readBonusNumber());
    }

    private LottoRankInfo createResult() {
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
