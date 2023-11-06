package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoValue;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public static void printLotto(LottoMachine lottoMachine) {
        lottoMachine.getLottos().stream().map(Lotto::toString).forEach(System.out::println);
    }

    public static void printResult(List<LottoValue> lottoValues) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoValue lottoValue : LottoValue.values()) {
            System.out.println(lottoValue.result + " - " + lottoValues.stream().filter(a -> a.name().equals(lottoValue.name())).count() + "개");
        }

    }

    public static void showProfit(List<LottoValue> matchedLottos, int numOfLotto) {
        int total = 0;
        for (LottoValue lottoValue : matchedLottos) {
            total += lottoValue.winningMoney;
        }
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("총 수익률은 " + df.format(((float) total/(numOfLotto*1000))*100) + "%입니다.");
    }
}
