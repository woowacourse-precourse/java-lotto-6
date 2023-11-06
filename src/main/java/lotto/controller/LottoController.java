package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.dto.IssuedLottoDetails;
import lotto.service.LottoManager;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoManager lottoManager;

    public LottoController(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void run() {
        PurchaseAmount purchaseAmount = repeatReadForInvalid(this::getPurchaseAmount);
        List<Lotto> issuedLottos = lottoManager.issueLotto(purchaseAmount);
        OutputView.printIssuedLottoDetails(IssuedLottoDetails.createIssuedLottoDetails(issuedLottos));

        WinningNumbers winningNumbers = repeatReadForInvalid(this::getWinningNumbers);
        lottoManager.addRankToWinningDetails(issuedLottos, winningNumbers);
        OutputView.printWinningDetails(lottoManager.getWinningDetailsToString());

        double profitRate = lottoManager.calculateProfitRate(purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private PurchaseAmount getPurchaseAmount() {
        return new PurchaseAmount(InputView.readPurchaseAmount());
    }

    private WinningNumbers getWinningNumbers() {
        return new WinningNumbers(
                InputView.readWinningNumbers(),
                InputView.readBonusNumber()
        );
    }

    private <T> T repeatReadForInvalid(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return repeatReadForInvalid(reader);
        }
    }
}
