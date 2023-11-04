package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.BuyAmount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.LottosDTO;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void buyLotto() {
        BuyAmount buyAmount = InputView.getBuyAmountFromInput();
        Lottos lottos = createLottosFromAmount(buyAmount);
        LottosDTO lottosDTO = lottos.toLottosDTO();
        OutputView.displayAllLottos(lottosDTO);
    }

    public void drawLotto() {
        WinningNumber winningNumber = InputView.getWinningNumberFromInput();
        BonusNumber bonusNumber = InputView.getBonusNumberFromInput();
    }

    private Lottos createLottosFromAmount(BuyAmount buyAmount) {
        List<Lotto> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < buyAmount.getAbleToBuyCount(); i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumber());
            lottoNumbers.add(lotto);
        }
        return new Lottos(lottoNumbers);
    }
}
