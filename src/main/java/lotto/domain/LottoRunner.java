package lotto.domain;

import java.util.List;
import lotto.domain.generator.BonusNumberGenerator;
import lotto.domain.generator.LottoAmountGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.WinningNumbersGenerator;
import lotto.io.OutputHandler;
import lotto.util.Calculator;

public class LottoRunner {
    final LottoAmountGenerator lottoAmountGenerator;
    final LottoGenerator lottoGenerator;
    final WinningNumbersGenerator winningNumbersGenerator;
    final BonusNumberGenerator bonusNumberGenerator;
    List<Lotto> lottos;
    Lotto winningNumbers;
    int bonusNumber;

    public LottoRunner() {
        lottoAmountGenerator = new LottoAmountGenerator();
        lottoGenerator = new LottoGenerator();
        winningNumbersGenerator = new WinningNumbersGenerator();
        bonusNumberGenerator = new BonusNumberGenerator();
    }

    public void run() {
        int amount = lottoAmountGenerator.generate();
        lottos = lottoGenerator.issueLotto(amount);

        OutputHandler.printLottoAmount(amount);
        OutputHandler.printLottos(lottos);

        winningNumbers = winningNumbersGenerator.generate();
        bonusNumber = bonusNumberGenerator.generate();

        Calculator calculator = new Calculator(lottos);
        calculator.printResult(winningNumbers, bonusNumber);
    }
}
