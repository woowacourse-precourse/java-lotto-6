package lotto.domain.lottoDrawMachine;

import lotto.domain.inputOutput.input.InputDataAdapter;
import lotto.domain.inputOutput.input.InputLottoDraw;
import lotto.domain.lottoDrawMachine.lottoDraw.LottoDraw;
import lotto.domain.lottoDrawMachine.lottoDraw.LottoDrawGenerator;

import java.util.List;

public class LottoDrawMachine {
    InputDataAdapter inputDataAdapter = new InputDataAdapter();
    InputLottoDraw inputLottoDraw = new InputLottoDraw();
    LottoDrawGenerator lottoDrawGenerator = new LottoDrawGenerator();

    public LottoDraw Raffle() {
        String inputLottoDrawNumbers = inputLottoDraw.inputLottoDrawNumber();
        List<Integer> lottoDrawNumbers = inputDataAdapter.transformLottoDrawNumber(inputLottoDrawNumbers);

        String inputLottoDrawBonusNumber = inputLottoDraw.inputLottoDrawBonusNumber();
        Integer lottoDrawBonusNumber = inputDataAdapter.transformLottoDrawBonusNumber(inputLottoDrawBonusNumber);

        return lottoDrawGenerator.generate(lottoDrawNumbers, lottoDrawBonusNumber);
    }
}
