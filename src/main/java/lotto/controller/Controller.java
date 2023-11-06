package lotto.controller;

import java.util.List;

import lotto.domain.Lottos;
import lotto.domain.Ranking;
import lotto.domain.Winnings;

import lotto.view.BonusLottoInput;
import lotto.view.BuyLottoInput;
import lotto.view.LottosOutput;
import lotto.view.RankingOutput;
import lotto.view.WinningLottoInput;

public class Controller {

    public static void Run() {
        int tickets = BuyLottoInput.buyLottoInput();
        Lottos lottos = LottosOutput.lottosOutput(tickets);
        winners(lottos);
    }

    public static void winners(Lottos lottos) {
        List<Integer> wins = WinningLottoInput.winnigLottoInput();
        int bonus = BonusLottoInput.bonusLottoInput(wins);
        Winnings winnings = new Winnings(wins, bonus);
        ranks(winnings, lottos);
    }

    public static void ranks(Winnings winnigs, Lottos lottos) {
        Ranking ranking = new Ranking();
        ranking.rewardRanking(winnigs, lottos);
        RankingOutput.rankingOutput(ranking);
    }

}