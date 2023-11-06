package lotto.controller;

import lotto.port.InputPort;
import lotto.service.LottoService;

public class LottoGameController {

    private final String INPUT_PURCHASEAMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private final InputPort inputPort;
    private final LottoService lottoService;

    public LottoGameController(InputPort inputPort, LottoService lottoService) {
        this.inputPort = inputPort;
        this.lottoService = lottoService;
    }

    public void playGame() {
        System.out.println(INPUT_PURCHASEAMOUNT_MESSAGE);
        String PurchaseAmount = inputPort.readLine();
        int LottoTicketsCount = lottoService.calculateNumberOfLottoTickets(PurchaseAmount);
    }

}
