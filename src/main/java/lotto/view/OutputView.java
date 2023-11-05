package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCountCalculator;
import lotto.domain.LottoProfitCalculator;
import lotto.util.OutputMessage;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printChances(int chance) {
        System.out.println("\n" + chance + OutputMessage.OUTPUT_MONEY_MESSAGE);
    }

    public void printLotto(List<Lotto> generatedLotto) {
        for (Lotto lotto : generatedLotto) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(Map<Integer, Integer> count, String Profit) {
        System.out.print(OutputMessage.OUTPUT_RESULT_INFO +
                        OutputMessage.OUTPUT_RESULT_3 + count.get(3) + OutputMessage.OUTPUT_RESULT_UNIT +
                        OutputMessage.OUTPUT_RESULT_4 + count.get(4) + OutputMessage.OUTPUT_RESULT_UNIT +
                        OutputMessage.OUTPUT_RESULT_5 + count.get(5) + OutputMessage.OUTPUT_RESULT_UNIT +
                        OutputMessage.OUTPUT_RESULT_B + count.get(7) + OutputMessage.OUTPUT_RESULT_UNIT +
                        OutputMessage.OUTPUT_RESULT_6 + count.get(6) + OutputMessage.OUTPUT_RESULT_UNIT +
                        OutputMessage.OUTPUT_RESULT_PROFIT_FIRST + Profit + OutputMessage.OUTPUT_RESULT_PROFIT_LAST
        );
    }
}
