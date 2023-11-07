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

        Prints.SHOW_GAME_RESULT.show();
        Results results = new Results(player.getLottos(), player.getWinLotto());
        results.calculate();
        results.showResult();
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", player.getRateOfReturn()));
    }
}
