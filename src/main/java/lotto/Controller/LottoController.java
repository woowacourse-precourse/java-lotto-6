package lotto.Controller;

import lotto.Model.Service.LottoService;
import lotto.View.LottoInput;
import lotto.View.LottoOutput;

public class LottoController {

    private final LottoService lottoService;
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoController(LottoService lottoService, LottoInput lottoInput,
            LottoOutput lottoOutput) {
        this.lottoService = lottoService;
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void purchaseLotto() {
        lottoService.createLotto(lottoInput.inputPurchaseAmount());
        lottoOutput.printTotalPurchaseAmount(lottoService.getLottos());
    }

}
