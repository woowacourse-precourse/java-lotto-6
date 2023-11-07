package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.UserLottoService;

public class LottoController {

    int amount;
    int bonusNum;
    Lotto lotto;
    private final UserLottoService lottoService = new UserLottoService();
    public void getLottoInput() {
        String lottoInput = Console.readLine();
        lotto = lottoService.stringToLotto(lottoInput);
    }

    public void getAmountInput() {
        String amountInput = Console.readLine();
        amount = Integer.parseInt(amountInput);
    }

    public void getBonusNumInput() {
        String bonusNumInput = Console.readLine();
        bonusNum = Integer.parseInt(bonusNumInput);
    }

    public void start() {

    }
}
