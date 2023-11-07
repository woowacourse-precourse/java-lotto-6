package lotto.domain;


import java.util.List;

public class WinningLotto extends Lotto {
    private final List<LottoNumber> winningNumbers;

    public WinningLotto(List<LottoNumber> winningNumbers) {
        super(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
