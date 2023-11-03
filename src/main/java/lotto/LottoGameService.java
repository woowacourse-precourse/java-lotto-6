package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoAmount;
import lotto.domain.Player;
import lotto.utils.Prints;
import lotto.utils.Utils;

public class LottoGameService {

    public void exec() {
        Player player = new Player();
        Prints.print_input_amount_message();
        player.setLottoAmount(getLottoAmount());
        player.setLottoCount();
        Prints.print_lottoCount(player.getLottoCount());
        player.createLotto();
    }

    private LottoAmount getLottoAmount() {
        return new LottoAmount(Utils.parseIntValidate(Console.readLine()));
    }
}
