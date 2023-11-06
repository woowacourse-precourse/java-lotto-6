package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void start() {
        InputView.printPayAmountInputMessage();
        String lottoPayAmount = Console.readLine();
        // TODO : 로또 구매 기능 인풋 Validate
        lottoService.processStart(Integer.parseInt(lottoPayAmount));
    }
}
