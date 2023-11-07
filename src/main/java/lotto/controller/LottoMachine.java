package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;
import lotto.input.PriceInputHandler;
import lotto.input.TargetNumberHandler;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Rank;
import lotto.service.Calculator;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoShop;
import lotto.view.LottoView;

public class LottoMachine {
    LottoView lottoView = new LottoView();
    PriceInputHandler priceInputHandler = new PriceInputHandler();
    TargetNumberHandler targetNumberHandler = new TargetNumberHandler();
    LottoShop lottoShop = new LottoShop(new LottoNumberGenerator());

    public void run() {
        LottoBuyer buyer = buyLotto();
        Map<Rank, Integer> result = matchLotto(buyer);
        calculateReward(buyer, result);
    }

    private LottoBuyer buyLotto() {
        int amount = priceInputHandler.dividePaymentIntoLottoPrice();
        List<Lotto> lottoTickets = lottoShop.sell(amount);
        lottoView.printLotto(lottoTickets);

        return new LottoBuyer(lottoTickets);
    }

    private Map<Rank, Integer> matchLotto(LottoBuyer buyer) {
        Lotto target = targetNumberHandler.setTargetLottoByInput();
        int bonus = targetNumberHandler.setBonusByInput(target);
        Console.close();

        return buyer.checkAllLotto(target, bonus);
    }

    private void calculateReward(LottoBuyer buyer, Map<Rank, Integer> result) {
        int payment = buyer.payment();
        double rateOfReturn = Calculator.calculateRateOfReturn(result, payment);

        lottoView.printResult(result, rateOfReturn);
    }
}
