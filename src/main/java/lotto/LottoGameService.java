package lotto;

import lotto.domain.Player;
import lotto.domain.Results;
import lotto.utils.Prints;

public class LottoGameService {

    public void exec() {
        Player player = new Player();
        player.setLottoAmount();
        player.setLottoCount();
        player.showLottoCount();

        player.createLotto();
        player.showLottos();

        player.createWinLotto();

        Prints.print_game_result();
        Results results = new Results(player.getLottos(), player.getWinLotto());
        results.calculate();
        results.showResult();
    }
}
