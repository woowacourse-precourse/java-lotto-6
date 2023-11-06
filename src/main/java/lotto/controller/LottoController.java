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
        List<Integer> winningNumbers = winningNumberLotto();
        int bonusNumber = bonusNumberLotto(winningNumbers);
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

    public List<Integer> winningNumberLotto() {
        while (true) {
            OutputView.lottoWinningNumberInputMessage();
            try {
                List<Integer> WinningNumber = lottoWinningNumber.lottoWinningNumber(InputView.input());

                OutputView.newLine();

                return WinningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public int bonusNumberLotto(List<Integer> lottoNumbers) {
        while (true) {
            OutputView.lottoBonusNumberInputMessage();
            try {
                int bonusNumber = lottoWinningNumber.lottoBonusNumber(InputView.input(), lottoNumbers);

                OutputView.newLine();

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }

    }

}
