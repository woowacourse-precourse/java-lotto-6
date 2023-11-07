package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PlayerLotto;
import lotto.dto.PurchaseLottoDto;
import lotto.service.LottoGameService;
import lotto.utils.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGameService lottoGameService;

    public LottoGameController(InputView inputView, OutputView outputView, LottoGameService lottoGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGameService = lottoGameService;
    }

    private int setPurchaseTotalCount() {
        while (true) {
            try {
                String purchaseAmount = inputView.readPurchaseAmount();
                PurchaseAmountValidator.validate(purchaseAmount);
                return Integer.parseInt(purchaseAmount) / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private PlayerLotto purchasePlayerLotto(final int purchaseTotalCount) {
        List<Lotto> purchaseLotto = lottoGameService.createPlayerLotto(purchaseTotalCount);
        outputView.printPurchaseLotto(new PurchaseLottoDto(purchaseLotto));
        return new PlayerLotto(purchaseLotto);
    }
}