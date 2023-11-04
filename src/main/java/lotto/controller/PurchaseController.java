package lotto.controller;

import lotto.domain.lottery.Buyer;
import lotto.domain.lottery.Lottos;
import lotto.dto.DtoAssembler;
import lotto.dto.LottoResponses;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.view.constants.PrintMessage.REQUEST_PURCHASE_PAYMENT;

public class PurchaseController {
    public Lottos purchase() {
        OutputView.printMessage(REQUEST_PURCHASE_PAYMENT);
        Buyer buyer = readPaymentInfo();

        Lottos lottos = Lottos.create(buyer);
        LottoResponses lottoResponses = DtoAssembler.createLottoResponses(buyer, lottos);

        OutputView.printPurchaseStatus(lottoResponses);
        return lottos;
    }

    private static Buyer readPaymentInfo() {
        try {
            final String paymentInput = InputView.readLine();
            return Buyer.from(paymentInput);
        } catch (LottoException exception) {
            OutputView.println(exception.getMessage());
            return readPaymentInfo();
        }
    }
}
