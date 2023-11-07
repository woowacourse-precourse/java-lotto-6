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
    private LottoRankInfo lottoRankInfo;
    private List<Integer> winningNumbers;
    private int bonusNumber = 0;
    private int buyAmount = 0;

    public LottoGameController(Game game) {
        this.game = game;
    }


    public void start() {
        getBuyAmount();
        createLottos();
        getWinningNumbers();
        getBonusNumber();
        createResult();
        printRank();
        printProfit();
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

    private void createResult() {
        lottoRankInfo = game.createResult(winningNumbers, bonusNumber);
    }

    private void printRank() {
        OutputView.printStartResult();
        OutputView.printWinningResult(lottoRankInfo.getLottoRankInfo());
    }

    private void printProfit() {
        OutputView.printProfitRate(game.createProfit(buyAmount, lottoRankInfo.getLottoRankInfo()));
    }


}
