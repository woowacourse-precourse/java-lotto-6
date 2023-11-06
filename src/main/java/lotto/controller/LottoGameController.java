package lotto.controller;

import lotto.port.InputPort;

public class LottoGameController {

    private final String INPUT_PURCHASEAMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private final InputPort inputPort;

    public LottoGameController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    public void playGame() {
        System.out.println(INPUT_PURCHASEAMOUNT_MESSAGE);
        String PurchaseAmount = inputPort.readLine();
    }

}
