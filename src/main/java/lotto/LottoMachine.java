package lotto;

import java.util.List;

public class LottoMachine {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoCalculator lottoCalculator = new LottoCalculator();

    public List<Lotto> createLottos(int lottoCount) {
        return lottoGenerator.createLottos(lottoCount);
    }

    public void setWinningNumberToCalculator(WinningNumber winningNumber) {
        lottoCalculator.setWinningNumber(winningNumber);
    }
}
