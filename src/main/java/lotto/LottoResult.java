package lotto;

import java.util.List;

public class LottoResult {

    private final WinningNumber winningNumber;
    private final List<Lotto> issuedLotto;

    public LottoResult(final WinningNumber winningNumber, final List<Lotto> issuedLotto) {
        this.winningNumber = winningNumber;
        this.issuedLotto = issuedLotto;
    }

    public long matchingCount(Lotto lotto) {
        return lotto.getNumbers().stream().filter(winningNumber.lotto().getNumbers()::contains).count();
    }
}
