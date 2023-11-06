package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Result;


public class OutputView {
    private final String AMOUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private final String RESULT_START_MESSAGE = "당첨 통계";
    private final String LINE = "---";
    private final String PROFIT_START_MESSEGE = "총 수익률은 %.1f";
    private final String PROFIT_END_MESSEGE = "%입니다.";

    public void printAmount(int amount) {
        System.out.println(String.format(AMOUNT_MESSAGE, amount));
    }

    public void printLottoInformation(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public void printResult(Result result) {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
        System.out.println(LINE);
        System.out.println(result.toString());
    }

    public void printProfitRate(double profit) {
        System.out.println(String.format(PROFIT_START_MESSEGE, profit) + PROFIT_END_MESSEGE);
    }
}
