package lotto.service;

import lotto.model.Payment;

public class LottoService {

    public void initLottoAmount(String inputAmount) {
        Payment payment = new Payment(inputAmount);
    }
}
