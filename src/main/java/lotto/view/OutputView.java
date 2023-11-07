package lotto.view;

import java.util.Collections;
import java.util.List;
import lotto.util.Utils;
import lotto.domain.ResultLotto;
import lotto.system.Constants;

public class OutputView {
    private OutputView() {
    }

    public static void printMyLotto(long count) {
        printMessage(count + "개를 구매했습니다.");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLotto(List<Integer> lotto) {
        printMessage(lotto.stream()
                .sorted()
                .toList()
                .toString()
        );
    }

    public static void printReward(List<ResultLotto> result) {
        printMessage("당첨 통계");
        printMessage("---");
        printMessage("3개 일치 (5,000원) - " + Collections.frequency(result, ResultLotto.THREE) + "개");
        printMessage("4개 일치 (50,000원) - " + Collections.frequency(result, ResultLotto.FOUR) + "개");
        printMessage("5개 일치 (1,500,000원) - " + Collections.frequency(result, ResultLotto.FIVE) + "개");
        printMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(result, ResultLotto.FIVE_BONUS) + "개");
        printMessage("6개 일치 (2,000,000,000원) - " + Collections.frequency(result, ResultLotto.SIX) + "개");
    }

    public static void printYield(float yield) {
        String floatFormatted = Utils.makeFloatFormatted(yield, Constants.YIELD_PRECISION.getConstants());
        printMessage("총 수익률은 " + floatFormatted + "%입니다.");
    }
}
