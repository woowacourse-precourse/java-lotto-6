package lotto.view;

import static lotto.util.OutputEnum.COUNT_UNIT;
import static lotto.util.OutputEnum.FIFTH_OUTPUT;
import static lotto.util.OutputEnum.FIRST_OUTPUT;
import static lotto.util.OutputEnum.FOURTH_OUTPUT;
import static lotto.util.OutputEnum.PUBLISHED_LOTTO_COUNT_OUTPUT;
import static lotto.util.OutputEnum.SECOND_OUTPUT;
import static lotto.util.OutputEnum.THIRD_OUTPUT;

import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.util.OutputEnum;

public class OutputView {

    public void printPublishedLottoCount(int lottoCount) {
        System.out.println(lottoCount + PUBLISHED_LOTTO_COUNT_OUTPUT.message());
    }

    public void printPublishedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printWinningResult(WinningResult result) {
        System.out.println(buildWinningResult(FIFTH_OUTPUT, result.getFifthPrizeLottoCount()));
        System.out.println(buildWinningResult(FOURTH_OUTPUT, result.getFourthPrizeLottoCount()));
        System.out.println(buildWinningResult(THIRD_OUTPUT, result.getThirdPrizeLottoCount()));
        System.out.println(buildWinningResult(SECOND_OUTPUT, result.getSecondPrizeLottoCount()));
        System.out.println(buildWinningResult(FIRST_OUTPUT, result.getFirstPrizeLottoCount()));
    }

    private String buildWinningResult(OutputEnum outputEnum, int lottoCount) {
        return outputEnum.message() + lottoCount + COUNT_UNIT.message();
    }

    public void printEarningRate() {

    }

}
