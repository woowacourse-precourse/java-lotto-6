package lotto.controller;

import lotto.service.InputLottoAmount;
import lotto.view.PrintMessage;

public class LottoController {
    public void startLotto() {
        setAmount();
    }

    public void setAmount() {
        PrintMessage.printStart();
        int lottoTicketCount = InputLottoAmount.setInputLottoAmount();
    }
}
