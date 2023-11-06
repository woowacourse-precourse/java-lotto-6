package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.winningLotto.BonusNumber;
import lotto.domain.winningLotto.WinningNumbers;
import lotto.domain.winningLotto.WinningLotto;
import lotto.dto.IssuedLottoDetails;
import lotto.service.LottoManager;
import lotto.utils.Converter;
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
        BonusNumber bonusNumber = repeatReadForInvalid(this::getBonusNumber);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        lottoManager.addRankToWinningDetails(issuedLottos, winningLotto);
        OutputView.printWinningDetails(lottoManager.getWinningDetailsToString());

        double profitRate = lottoManager.calculateProfitRate(purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }

    private PurchaseAmount getPurchaseAmount() {
        int purchaseAmount = Converter.convertToInt(InputView.readPurchaseAmount());
        return new PurchaseAmount(purchaseAmount);
    }

    private WinningNumbers getWinningNumbers() {
        List<Integer> winningNumbers =
                Converter.convertToIntegerListWithDelimiter(InputView.readWinningNumbers(), ",");
        return new WinningNumbers(winningNumbers);
    }

    private BonusNumber getBonusNumber() {
        int bonusNumber = Converter.convertToInt(InputView.readBonusNumber());
        return new BonusNumber(bonusNumber);
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
