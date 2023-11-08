package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PrizeMoney;
import lotto.domain.WinningBonusLotto;
import lotto.view.LottoView;

import java.util.List;

public class StatisticsController {
    private static final LottoView view = new LottoView();
    private Player player;
    private WinningBonusLotto winningBonuslotto;

    public void CountWinningNumber(Player player) {
        this.player = player;
        this.winningBonuslotto = player.getWinningBonusLotto();
        matchAllLottos(player.getLottos(), winningBonuslotto.getWinningLotto());
        view.outputMatchResult(player.getMatches());
        double rate = calculateRate();
        view.outputStatisticsResult(rate);
    }

    private void matchAllLottos(List<Lotto> lottos, Lotto winning) {
        for (Lotto lotto : lottos) {
            int count = countMatchLotto(lotto, winning);
            addMatchCount(lotto, count);
        }
    }

    private int countMatchLotto(Lotto lotto, Lotto winning) {
        int count = 0;
        for (int number : lotto.getNumbers())
            if (winning.getNumbers().contains(number))
                count++;
        return count;
    }

    private void addMatchCount(Lotto lotto, int count) {
        if (count == 3)
            player.addThreeMatch();
        if (count == 4)
            player.addFourMatch();
        if (count == 5)
            matchBonusNumber(lotto);
        if (count == 6)
            player.addSixMatch();
    }

    private void matchBonusNumber(Lotto lotto) {
        if (lotto.getNumbers().contains(winningBonuslotto.getBonusNumber())) {
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

        return ((double) totalMoney / player.getPayment()) * 100;
    }
}
