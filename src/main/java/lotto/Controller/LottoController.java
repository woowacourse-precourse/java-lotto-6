package lotto.Controller;

import lotto.Model.Service.LottoService;
import lotto.View.LottoInput;
import lotto.View.LottoOutput;

public class LottoController {

    private final LottoService lottoService;
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
        this.lottoInput = new LottoInput();
        this.lottoOutput = new LottoOutput();
    }

    public void purchaseLotto() {
        lottoService.createLotto(lottoInput.inputPurchaseAmount());
        lottoOutput.printTotalPurchaseAmount(lottoService.getLottos());
    }
}
