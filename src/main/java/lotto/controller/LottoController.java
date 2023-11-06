package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoController {

    LottoPurchase lottoPurchase = new LottoPurchase();
    LottoNumber lottoNumber = new LottoNumber();
    LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    public void run() {
        int lottoAmount = purchaseLotto();
        List<Lotto> lottoTickets = publishLotto(lottoAmount);
        winningNumberLotto();
    }

    public int purchaseLotto() {
        while (true) {
            OutputView.lottoPurchaseInputMessage();
            try {
                int lottoCount = lottoPurchase.lottoPurchaseCount(InputView.input());

                OutputView.newLine();

                return lottoCount;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public List<Lotto> publishLotto(int lottoCount) {
        OutputView.lottoPurchaseCheckOutputMessage(lottoCount);

        List<Lotto> lottoTickets = lottoNumber.lottoTickets(lottoCount);

        OutputView.newLine();

        return lottoTickets;
    }

    public void winningNumberLotto() {
        OutputView.lottoWinningNumberInputMessage();
        lottoWinningNumber.lottoWinningNumber(InputView.input());
    }

}
