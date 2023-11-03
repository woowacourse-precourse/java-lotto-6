package lotto.controller;

import static lotto.controller.InputController.inputController;

import lotto.dto.InputDto;
import lotto.model.repository.service.LottoService;

public class LottoController {
    private static LottoService service;

    public LottoController() {
        this.service = new LottoService();
    }

    public void run() {
        InputDto inputDto = new InputDto();

        inputController(inputDto);

        MainController();

        OutputController();
    }

    private void MainController() {
    }

    private void OutputController() {
    }


}
