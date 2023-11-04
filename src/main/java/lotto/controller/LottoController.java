package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.BuyAmount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Lottos;
import lotto.domain.LottosDTO;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private BuyAmount buyAmount;
    private Lottos lottos;
    private WinningNumbers winningNumbers;

    public void buyLotto() {
        buyAmount = InputView.getBuyAmountFromInput();
        lottos = createLottosFromAmount(buyAmount);
        LottosDTO lottosDTO = lottos.toLottosDTO();
        OutputView.displayAllLottos(lottosDTO);
    }

    public void drawLotto() {
        List<Integer> winningNumber = InputView.getWinningNumberFromInput();
        int bonusNumber = InputView.getBonusNumberFromInput();
        winningNumbers = new WinningNumbers(winningNumber, bonusNumber);
    }

    public void statistics() {

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
