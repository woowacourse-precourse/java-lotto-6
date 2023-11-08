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
        boolean isCollectBonusNumberInput = true;
        List<Integer> lottoDrawNumbers = null;
        Integer lottoDrawBonusNumber = null;
        LottoDraw lottoDraw = null;
        while (isCollectNumberInput) {
            try {
                String inputLottoDrawNumbers = inputLottoDraw.inputLottoDrawNumber();
                lottoDrawNumbers = inputDataAdapter.transformLottoDrawNumber(inputLottoDrawNumbers);
                isCollectNumberInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (isCollectBonusNumberInput) {
            try {
                String inputLottoDrawBonusNumber = inputLottoDraw.inputLottoDrawBonusNumber();
                lottoDrawBonusNumber = inputDataAdapter.transformLottoDrawBonusNumber(inputLottoDrawBonusNumber, lottoDrawNumbers);
                isCollectBonusNumberInput = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        lottoDraw = lottoDrawGenerator.generate(lottoDrawNumbers, lottoDrawBonusNumber);

        return lottoDraw;
    }
}
