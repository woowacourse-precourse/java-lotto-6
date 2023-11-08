package lotto.controller;

import static lotto.view.constants.OutputMessage.RESULT_MESSAGE;
import static lotto.view.constants.OutputMessage.WINNING_BONUS_MESSAGE;
import static lotto.view.constants.OutputMessage.WINNING_MESSAGE;
import static lotto.view.constants.OutputMessage.WINNING_STATISTICS_MESSAGE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.config.GamePrizeConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchasedLotto;
import lotto.view.OutputView;

public class LottoResultService {
    public LottoResult createLottoResult(PurchasedLotto purchasedLotto, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> winningResult = purchasedLotto.getWinningResult(winningLotto, bonusNumber);
        return new LottoResult(winningResult);
    }

    public void printWinningStatistics(LottoResult lottoResult, PurchaseAmount purchaseAmount) {
        List<GamePrizeConfig> prizes = Arrays.asList(GamePrizeConfig.values());
        Collections.reverse(prizes);
        int winningIndex = prizes.size();

        for (GamePrizeConfig prize : prizes) {
            winningIndex--;
            String winningMessage = isBonusTrue(prize.getCheckBonus());
            OutputView.printMessage(String.format(
                    winningMessage,
                    prize.getCorrectCount(),
                    prize.getPrizeText(),
                    lottoResult.getCount(winningIndex)
            ));
        }
    }

    private String isBonusTrue(boolean bonus) {
        if (bonus) {
            return WINNING_BONUS_MESSAGE.getMessage();
        }
        return WINNING_MESSAGE.getMessage();
    }

    public void printIncomeRate(LottoResult lottoResult, PurchaseAmount purchaseAmount) {
        double incomeRate = lottoResult.calculateIncomeRate(purchaseAmount.getMoney());
        OutputView.printMessage(String.format(RESULT_MESSAGE.getMessage(), incomeRate));
    }

    public void printMessageBeforeResult() {
        OutputView.printNewLine();
        OutputView.printMessage(WINNING_STATISTICS_MESSAGE.getMessage());
    }
}
