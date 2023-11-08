package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.WinningNumberLotto;
import lotto.view.InputBonusNumber;
import lotto.view.InputPurchaseAmountView;
import lotto.view.InputWinningNumberView;

import java.util.List;

public class LottoController {

    private Price getLottoPrice(){
        InputPurchaseAmountView inputPurchaseAmountView = new InputPurchaseAmountView();
        int purchaseAmount = inputPurchaseAmountView.inputAmountView();
        return new Price(purchaseAmount);
    }

    private Lottos getLottos(Price price) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.LottosGenerator(price.getPrice()));
    }

    private WinningNumberLotto getWinningNumberLotto(){
        InputWinningNumberView inputWinningNumberView = new InputWinningNumberView();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> winningNumbers = inputWinningNumberView.inputWinningNumbers();
        int bonusNumber = inputBonusNumber.inputBonusNumber();

        return new WinningNumberLotto(winningNumbers, bonusNumber);
    }
}
