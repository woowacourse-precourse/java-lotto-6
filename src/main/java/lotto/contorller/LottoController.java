package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class LottoController {

    int amount;
    Lotto lotto;
    private final LottoService lottoService = new LottoService();
    public void getLottoInput() {
        String lottoInput = Console.readLine();
        lotto = lottoService.stringToLotto(lottoInput);
    }

    public void getAmountInput() {
        String amountInput = Console.readLine();
        amount = Integer.parseInt(amountInput);
    }
}
