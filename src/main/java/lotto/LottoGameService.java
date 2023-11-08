package lotto;

import lotto.domain.player.Player;

public class LottoGameService {

    public void exec() {
        Player player = new Player();
        player.setLottoAmount();
        player.setLottoCount();
        player.showLottoCount();

        player.createLotto();
        player.showLottos();

        player.createWinLotto();

        player.calculate();
    }
}
