package lotto;

import lotto.domain.Player;
import lotto.utils.Prints;

public class LottoGameService {

    public void exec() {
        Player player = new Player();
        Prints.print_input_amount_message();
        player.setLottoAmount();
        player.setLottoCount();
        Prints.print_lottoCount(player.getLottoCount());
        player.createLotto();
        player.showLottos();
    }
}
