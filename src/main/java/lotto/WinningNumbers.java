package lotto;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(String inputWinningLotto, String inputBonus) {
        validateInputLotto(inputWinningLotto);
        validateInputBonus(inputBonus);
        this.winningLotto = new Lotto(inputToNumbers(inputWinningLotto));
        this.bonusNumber = inputToNumber(inputBonus);
    }

    public List<Integer> getWinningLottoNumbers() {
        return this.winningLotto.getNumbers();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
