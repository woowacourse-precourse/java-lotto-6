package lotto;

import lotto.domain.player.Player;
import lotto.utils.Prints;
import lotto.utils.Utils;

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
        player.calculate();
        Utils.showResult();
        Prints.SHOW_RATE_OF_RETURN.showFormat(player.getRateOfReturn());
    }
}
