package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class LottoCompany {
    private WinningNumbers winningNumbers;
    private BonusNumbers bonusNumbers;

    private LottoCompany(WinningNumbers winningNumbers, BonusNumbers bonusNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumbers = bonusNumbers;
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumbers getBonusNumbers() {
        return bonusNumbers;
    }

    public static LottoCompany createlottoCompany() {
        List<Integer> numbers;
        numbers = (List<Integer>) InputView.INPUT_WINNING_NUMBER.activateView();
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        System.out.println();
        numbers = (List<Integer>) InputView.INPUT_BONUS_NUMBER.activateView();
        BonusNumbers bonusNumbers = new BonusNumbers(numbers);
        return new LottoCompany(winningNumbers, bonusNumbers);
    }
}
