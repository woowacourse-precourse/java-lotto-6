package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.input.PriceInputHandler;
import lotto.input.TargetNumberHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Rank;
import lotto.service.Calculator;
import lotto.service.LottoShop;
import lotto.view.LottoView;

public class LottoMachine {
    LottoView lottoView = new LottoView();
    PriceInputHandler purchaseInputHandler = new PriceInputHandler();
    TargetNumberHandler targetInputHandler = new TargetNumberHandler();

    public void run() {
        LottoBuyer buyer = buyLotto();
        Map<Rank, Integer> result = matchLotto(buyer);
        calculate(buyer, result);
    }

    private LottoBuyer buyLotto() {
        int amount = purchaseInputHandler.dividePaymentIntoLottoPrice();
        List<Lotto> lottoTickets = LottoShop.sell(amount);
        lottoView.printLotto(lottoTickets);

        return new LottoBuyer(lottoTickets);
    }

    private Map<Rank, Integer> matchLotto(LottoBuyer buyer) {
        Lotto target = targetInputHandler.setTargetLottoByInput();
        int bonus = targetInputHandler.setBonusByInput(target);

        return buyer.checkAllLotto(target, bonus);
    }

    private void calculate(LottoBuyer buyer, Map<Rank, Integer> result) {
        int payment = buyer.payment();
        double rateOfReturn = Calculator.calculateRateOfReturn(result, payment);
        lottoView.printResult(result, rateOfReturn);
    }
}
