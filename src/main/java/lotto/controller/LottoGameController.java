package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Game;
import lotto.model.LottoRank;
import lotto.model.LottoRankInfo;
import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private Game game;
    private Lottos lottos;

    private List<Integer> winningNumbers;

    private int bonusNumber = 0;


    public void start() {
        game = new Game();
        OutputView.printRequestBuyAmount();
        int buyAmount = 0;
        while (true) {
            try {
                buyAmount = Integer.parseInt(InputView.readBuyAmount());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }
        }

        OutputView.printBuyCount(buyAmount);
        lottos = game.createLottos(buyAmount);
        OutputView.printCreatedLottos(lottos);

        OutputView.printRequestWinningNumber();
        String[] numbers = InputView.readWinningNumber().split(",");
        winningNumbers = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toList());

        OutputView.printRequestBonusNumber();
        bonusNumber = Integer.parseInt(InputView.readBonusNumber());

        LottoRankInfo lottoRankinfo = game.createResult(lottos, winningNumbers, bonusNumber);
        OutputView.printStartResult();
        OutputView.printWinningResult(lottoRankinfo.getLottoRankInfo());

        OutputView.printProfitRate(game.createProfit(buyAmount, lottoRankinfo.getLottoRankInfo()));
    }


}
