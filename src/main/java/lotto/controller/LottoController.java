package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import lotto.model.Buyer;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.dto.LottoPaper;
import lotto.utils.NumberParser;
import lotto.view.InputView;
import lotto.view.OuputView;

public class LottoController {
    private final InputView inputView;
    private final OuputView ouputView;
    private final LottoSeller lottoSeller = new LottoSeller();

    public LottoController(InputView inputView, OuputView ouputView) {
        this.inputView = inputView;
        this.ouputView = ouputView;
    }

    public void run() {
        final Buyer lottoBuyer = buyLotto();
        final List<LottoPaper> lottoPapers = lottoBuyer.getLottoPapers();
        ouputView.printPublishedLottos(lottoPapers);

    }

    public Buyer buyLotto() {
        final Money purchasingMoney = inputMoney();
        final Lottos publishedLottos = lottoSeller.sell(purchasingMoney);
        return new Buyer(purchasingMoney, publishedLottos);
    }

    private Money inputMoney() {
        Optional<Money> purchasingMoney = generateMoney();
        while (purchasingMoney.isEmpty()) {
            purchasingMoney = generateMoney();
        }
        return purchasingMoney.get();
    }

    private Optional<Money> generateMoney() {
        try {
            String inputMoney = inputView.insertMoney();
            BigDecimal parsedMoney = NumberParser.parseMoney(inputMoney);
            return Optional.of(new Money(parsedMoney));
        } catch (IllegalArgumentException e) {
            String errorMessage = e.getMessage();
            ouputView.printErrorMessage(errorMessage);
        }
        return Optional.empty();
    }
}
