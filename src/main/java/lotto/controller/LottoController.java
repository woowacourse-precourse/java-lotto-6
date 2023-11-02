package lotto.controller;

import lotto.service.InputLottoAmount;

public class LottoController {
    public void startLotto() {
        setAmount();
    }

    public void setAmount() {
        int lottoTicketCount = InputLottoAmount.setInputLottoAmount();

    }
}
