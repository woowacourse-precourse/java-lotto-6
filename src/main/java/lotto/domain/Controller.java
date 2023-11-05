package lotto.domain;

import lotto.model.LottoTicket;
import lotto.model.Purchase;
import lotto.validator.ValidatorPurchaseAmount;
import lotto.view.View;

public class Controller {
    public void lotto_Logic() {
        View view = new View();
        view.inputPurchaseAmount();
        Purchase purchase = new Purchase(view.input());

        ValidatorPurchaseAmount validatorPurchaseAmount = new ValidatorPurchaseAmount();

        while (!validatorPurchaseAmount.processPurchaseAmountError(purchase)) {
            validatorPurchaseAmount.processErrorResult();

            purchase = new Purchase(view.input());
            validatorPurchaseAmount = new ValidatorPurchaseAmount();
        }

        LottoTicket lottoTicket = new LottoTicket(calculateLottoTicketCount(purchase));
    }

    public int calculateLottoTicketCount(Purchase purchase) {
        return Integer.parseInt(purchase.getPurchaseAmount())/1000;
    }
}
