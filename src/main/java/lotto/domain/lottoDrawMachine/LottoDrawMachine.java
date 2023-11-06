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
        boolean isCollectNumberInput = true;
        List<Integer> lottoDrawNumbers = null;
        Integer lottoDrawBonusNumber = null;
        LottoDraw lottoDraw = null;
        while (isCollectNumberInput) {
            try {
                String inputLottoDrawNumbers = inputLottoDraw.inputLottoDrawNumber();
                lottoDrawNumbers = inputDataAdapter.transformLottoDrawNumber(inputLottoDrawNumbers);

                String inputLottoDrawBonusNumber = inputLottoDraw.inputLottoDrawBonusNumber();
                lottoDrawBonusNumber = inputDataAdapter.transformLottoDrawBonusNumber(inputLottoDrawBonusNumber);

                lottoDraw = lottoDrawGenerator.generate(lottoDrawNumbers, lottoDrawBonusNumber);
                isCollectNumberInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return lottoDraw;
    }
}
