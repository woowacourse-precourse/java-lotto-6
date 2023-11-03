package lotto.controller;

import lotto.dto.InputDto;
import lotto.model.service.LottoService;

public class LottoController {
    private final LottoService service;

    public LottoController() {
        this.service = new LottoService();
    }

    public void run() {
        InputDto inputDto = new InputDto();

        InputController.InputLottoPurchaseAmount(inputDto);

        service.createLottos(inputDto);
        MainController();

        OutputController();
    }

    private void MainController() {
    }

    private void OutputController() {
    }


}
