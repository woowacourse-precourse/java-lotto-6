package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.service.UserLottoService;

import static java.lang.Integer.parseInt;

public class LottoController {
    UserLotto userLotto;
    private final UserLottoService lottoService = new UserLottoService();
    public Lotto getLottoInput() {
        String lottoInput = Console.readLine();
        return lottoService.stringToLotto(lottoInput);
    }

    public int getAmountInput() {
        String amountInput = Console.readLine();
        return Integer.parseInt(amountInput);
    }

    public int getBonusNumInput() {
        String bonusNumInput = Console.readLine();
        return Integer.parseInt(bonusNumInput);
    }

    public void init() {;
        userLotto = lottoService.getUserLotto(getLottoInput(), getBonusNumInput(), getAmountInput());

    }
}
