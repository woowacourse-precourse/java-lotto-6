package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.ResultType;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static final String PRINT_AMOUNT = "%d개를 구매했습니다.";
    public static final String PRINT_RESULT = "당첨 통계\n"+"---";
    public static final String PRINT_PROFIT = "총 수익률은 %.1f%%입니다.";

    public void printAmount(int amount) {
        System.out.println(String.format(PRINT_AMOUNT,amount/1000));
    }

    public void printLottos(List<Lotto> lottos) {
        for(Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
    public void printResult(Map<ResultType,Integer> result) {
        System.out.println(PRINT_RESULT);
        for(ResultType resultType:ResultType.values()) {
            if(resultType!=ResultType.NOTHING)
                System.out.println(resultType.getDescription()+result.get(resultType)+"개");
        }
    }
    public void printProfit(double profit) {
        System.out.println(String.format(PRINT_PROFIT,profit));
    }
}
