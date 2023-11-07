package lotto;

import lotto.domain.Player;
import lotto.domain.WinLotto;
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

        WinLotto winLotto = new WinLotto();
        Prints.print_input_winLotto();
        winLotto.createLotto();
        Prints.print_input_bonusnumber();
        winLotto.createBonusNumber();

        Prints.print_game_result();
    }
}
