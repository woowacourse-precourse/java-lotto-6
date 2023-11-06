package lotto.contorller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.service.LottoService;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    public void getAmountInput() {
        String amountInput = Console.readLine();
        Lotto lotto = lottoService.stringToLotto(amountInput);
    }
}
