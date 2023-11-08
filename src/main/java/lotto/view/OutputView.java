package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.roulette.RouletteResult;

import java.util.List;
import java.util.Map;

import static lotto.constant.SystemConstant.*;

public class OutputView {
    public void outputLottoCount(int count) {
        System.out.println();
        System.out.printf(OUTPUT_LOTTO_BUY_COUNT_MESSAGE.getMessage(), count);
    }

    public void outputLottosNumber(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::toStringLotto)
                .forEach(System.out::println);
    }
    public void showResult(Map<RouletteResult, Integer> result) {
        System.out.println();
        System.out.print(OUTPUT_RESULT_MESSAGE.getMessage());
        System.out.print(LINE.getMessage());
        for (RouletteResult rouletteResult : RouletteResult.values()
        ) {
            if (rouletteResult != RouletteResult.FAILURE) {
                System.out.printf(OUTPUT_RESULT_COUNT_MESSAGE.getMessage(), rouletteResult.getMessage(), result.get(rouletteResult));
            }
        }
    }

    public void showRate(double rate) {
        System.out.printf(OUTPUT_RESULT_RATE_MESSAGE.getMessage(), rate);
    }
}
