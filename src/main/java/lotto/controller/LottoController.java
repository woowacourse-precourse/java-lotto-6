package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.dto.LottoMatchCountDto;
import lotto.model.LottoModel;
import lotto.validate.BonusNumberValidation;
import lotto.validate.PurchaseAmountValidation;
import lotto.validate.WinningNumberValidation;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoController {
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;
    private final LottoModel lottoModel;

    public LottoController(final LottoInputView lottoInputView, final LottoOutputView lottoOutputView, final LottoModel lottoModel) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
        this.lottoModel = lottoModel;
    }

    public void startGame() {
        lottoOutputView.printUserInputPurchaseAmount();
        int purchaseAmount = lottoInputView.inputPurchaseAmount(new PurchaseAmountValidation());

        lottoOutputView.printPurchaseAmountCount(purchaseAmount);
        List<Lotto> lottos = lottoModel.getRandomLottos(purchaseAmount / 1000);
        lottoOutputView.printLottos(lottos);

        lottoOutputView.printUserInputWinningNumber();
        List<Integer> winningNumbers = lottoInputView.inputWinningNumber(new WinningNumberValidation());

        lottoOutputView.printUserInputBonusNumber();
        int bonusNumber = lottoInputView.inputBonusNumber(new BonusNumberValidation(), winningNumbers);

        List<LottoMatch> lottoMatches = lottoModel.getLottoMatches(lottos, winningNumbers, bonusNumber);
        LottoMatchCountDto lottoMatchCountDto = lottoModel.getLottoMatchCount(lottoMatches);
        lottoOutputView.printLottoResult(lottoMatchCountDto);

    }
}
