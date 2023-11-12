package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.view.LottoView;

public class WinningLottoController {
    private final WinningLotto winningLotto;
    private final LottoView lottoView;

    public WinningLottoController(LottoView lottoView) {
        this.lottoView = lottoView;
        this.winningLotto = winningLottoGenerating(WinningLottoNumbersGenerating());
    }

    private Lotto WinningLottoNumbersGenerating() {
        Lotto lotto = null;
        while (lotto == null) {
            lotto = createWinningLottoNumbers(lotto);
            lottoView.print("");
        }
        return lotto;
    }

    private Lotto createWinningLottoNumbers(Lotto lotto){
        try {
            lotto = createWinningLottoNumbersComplete(lottoView.winningLottoInput());
        } catch (IllegalArgumentException e) {
            lottoView.print(e.getMessage());
        }
        return lotto;
    }


    private Lotto createWinningLottoNumbersComplete(String numbers) {
        return new Lotto(
                Arrays.stream(numbers.split(","))
                        .map(it -> Integer.parseInt(it.trim()))
                        .collect(Collectors.toList())
        );
    }

    private WinningLotto winningLottoGenerating(Lotto winningLottoNumbers) {
        WinningLotto winningLotto = null;
        while (winningLotto == null) {
            winningLotto = createWinningLotto(winningLottoNumbers, winningLotto);
            lottoView.print("");
        }
        return winningLotto;
    }

    private WinningLotto createWinningLotto(Lotto winningLottoNumbers, WinningLotto winningLotto) {
        try {
            int bonusNumber = bonusNumberGenerating(lottoView.bonusNumberInput());
            winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            lottoView.print(e.getMessage());
        }
        return winningLotto;
    }

    private int bonusNumberGenerating(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
