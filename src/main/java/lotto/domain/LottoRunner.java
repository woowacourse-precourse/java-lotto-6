package lotto.domain;

import java.util.List;
import lotto.domain.generator.BonusNumberGenerator;
import lotto.domain.generator.LottoAmountGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.WinningLottoGenerator;
import lotto.io.OutputHandler;
import lotto.util.Calculator;

public class LottoRunner {
    LottoAmountGenerator lottoAmountGenerator;
    LottoGenerator lottoGenerator;
    WinningLottoGenerator winningNumbersGenerator;
    BonusNumberGenerator bonusNumberGenerator;
    List<Lotto> lottos;
    Lotto winningNumbers;
    int bonusNumber;

    public LottoRunner() {
        lottoAmountGenerator = new LottoAmountGenerator();
        lottoGenerator = new LottoGenerator();
        winningNumbersGenerator = new WinningLottoGenerator();
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
