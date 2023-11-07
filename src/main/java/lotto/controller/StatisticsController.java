package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PrizeMoney;
import lotto.view.LottoView;

import java.util.List;

public class StatisticsController {
    private static final LottoView view = new LottoView();
    private Player player;

    public void CountWinningNumber(Player player) {
        this.player = player;
        matchAllLottos(player.getLottos(), player.getWINNING_NUMBERS());
        double rate = calculateRate();
        view.outputStatisticsResult(player.getMatches(), rate);
    }

    private void matchAllLottos(List<Lotto> lottos, Lotto winningNumbers) {
        for (Lotto lotto : lottos) {
            int count = countMatchLotto(lotto, winningNumbers);
            addMatchCount(lotto, count);
        }
    }

    private int countMatchLotto(Lotto lotto, Lotto winningNumbers) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number))
                count++;
        }
        return count;
    }

    private void addMatchCount(Lotto lotto, int count) {
        if (count == 3)
            player.addThreeMatch();
        if (count == 4)
            player.addFourMatch();
        if (count == 5)
            matchBonusNumber(lotto, player.getBONUS_NUMBER());
        if (count == 6)
            player.addSixMatch();
    }

    private void matchBonusNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            player.addFiveAndBonusMatch();
            return;
        }
        player.addFiveMatch();
    }

    private double calculateRate() {
        int totalMoney = 0;
        totalMoney += player.getThreeMatch() * PrizeMoney.THREE_MATCH_PRIZE_MONEY.getPrize();;
        totalMoney += player.getFourMatch() * PrizeMoney.FOUR_MATCH_PRIZE_MONEY.getPrize();
        totalMoney += player.getFiveMatch() * PrizeMoney.FIVE_MATCH_PRIZE_MONEY.getPrize();
        totalMoney += player.getFiveAndBonusMatch() * PrizeMoney.FIVE_AND_BONUS_MATCH_PRIZE_MONEY.getPrize();
        totalMoney += player.getSixMatch() * PrizeMoney.SIX_MATCH_PRIZE_MONEY.getPrize();

        return (totalMoney / player.getPayment()) * 100;
    }
}
