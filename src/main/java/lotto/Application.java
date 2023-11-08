package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        Player player = new Player(inputView.inputMoney());


        int countTickets = player.countTickets();
        outputView.lottoView(countTickets);

        Game game = new Game(inputView.inputAnswer(), inputView.inputBonus());

        for(int i=0;i<=countTickets;i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            //outputView.lottoSortView(lotto.getNumbers());
            player.countRanking(lotto.decideResult(game.answer, game.bonusNumber));
        }

        outputView.resultStatiticView(player.rankings);
        outputView.rewardRateView(player.calculateReward());


    }
}
