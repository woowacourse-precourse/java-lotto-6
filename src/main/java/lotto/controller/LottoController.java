package lotto.controller;

import lotto.dto.InputDto;
import lotto.model.service.LottoService;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService service;

    public LottoController() {
        this.service = new LottoService();
    }

    public void run() {
        InputDto inputDto = new InputDto();

        InputController.inputLottoPurchaseAmount(inputDto);
        service.createLottos(inputDto);
        OutputView.outputAllLottoNumbers(service.getLottos());
    }
}
