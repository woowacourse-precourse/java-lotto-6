package lotto.controller;

import lotto.constants.Ranks;
import lotto.domain.Lotto;
import lotto.domain.LottoRound;
import lotto.domain.Player;
import lotto.domain.Rank;
import lotto.util.ConvertorUtil;
import lotto.util.NumberUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static lotto.constants.OutputMessages.MATCH_NUMBER;


public class GameController {
    private  final InputView inputView = new InputView();
    private  final OutputView outputView = new OutputView();

    public void start() {
        final int inputPrice = getInputPrice();
        Player player = new Player(inputPrice);
        outputView.printIssuedLottoes(player.getRegularNumbers().size(), player.getIssuedLottoMessages());

        LottoRound lottoRound = getAnswer();
        List<Lotto> inputs = player.getRegularNumbers();
        List<Ranks> ranks = Rank.calculateRanks(lottoRound, inputs);

        Arrays.stream(Ranks.values()).forEach(ranks1 -> {
            outputView.printMatchResult(ranks1, String.valueOf(ranks
                    .stream()
                    .filter(ranks2 -> ranks2.getMoney() == ranks1.getMoney())
                    .count()));
        });
        outputView.printProfit(NumberUtil.getRate(inputPrice, ranks).toPlainString());
    }



    private LottoRound getAnswer() {
        return LottoRound.of(
                new Lotto(getRegularNumber()),
                getBonusNumber()
        );
    }

    private List<Integer> getRegularNumber() {
        try {
            return inputView.readWinNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getRegularNumber();
        }
    }

    private Integer getBonusNumber() {
        try {
            return inputView.readBonusNumber();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getBonusNumber();
        }
    }

    private Integer getInputPrice() {
        try {
            return Integer.parseInt(inputView.readBuyAmount().amount());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getInputPrice();
        }
    }
}
