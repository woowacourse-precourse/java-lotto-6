package lotto.controller;

import lotto.port.InputPort;

public class LottoGameController {

    private final InputPort inputPort;

    public LottoGameController(InputPort inputPort) {
        this.inputPort = inputPort;
    }

    public void playGame() {
        System.out.println("구입금액을 입력해 주세요.");
        String s = inputPort.readLine();
    }

}
