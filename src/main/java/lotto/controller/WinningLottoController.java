package lotto.controller;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.LottoView;

public class WinningLottoController {
    private final WinningLotto winningLotto;
    private final LottoView lottoView;

    public WinningLottoController(LottoView lottoView) {
        this.lottoView = lottoView;
        this.winningLotto = winningLottoGenerating(createWinningLotto());
    }

    private Lotto createWinningLotto() {
        boolean successInput = false;
        Lotto lotto = null;
        while (!successInput) {
            try {
                lotto = winningLottoGenerating(lottoView.winningLottoInput());
                successInput = true;
            } catch (IllegalArgumentException e) {
                lottoView.print(e.getMessage());
            }
            lottoView.print("");
        }
        return lotto;
    }

    private Lotto winningLottoGenerating(String numbers) {
        return new Lotto(
                Arrays.stream(numbers.split(","))
                        .map(it -> Integer.parseInt(it.trim()))
                        .collect(Collectors.toList())
        );
    }

    public WinningLotto winningLottoGenerating(Lotto winningLottoNumbers) {
        WinningLotto winningLotto = null;
        boolean successInput = false;
        while (!successInput) {
            try {
                int bonusNumber = bonusNumberGenerating(lottoView.bonusNumberInput());
                winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
                successInput = true;
            } catch (IllegalArgumentException e) {
                lottoView.print(e.getMessage());
            }
            lottoView.print("");
        }
        return winningLotto;
    }

    public int bonusNumberGenerating(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
