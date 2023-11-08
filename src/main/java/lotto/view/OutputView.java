package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.roulette.RouletteResult;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void outputLottoCount(int count) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", count);
    }

    public void outputLottosNumber(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::toStringLotto)
                .forEach(System.out::println);
    }
    public void showResult(Map<RouletteResult, Integer> result) {
        System.out.println();
        System.out.print("당첨 통계\n");
        System.out.print("---\n");
        for (RouletteResult rouletteResult : RouletteResult.values()
        ) {
            if (rouletteResult != RouletteResult.FAILURE) {
                System.out.printf("%s - %d개\n", rouletteResult.getMessage(), result.get(rouletteResult));
            }
        }
    }

    public void showRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}
