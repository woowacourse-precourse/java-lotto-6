package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WiningStatistics;
import lotto.model.WiningType;
import lotto.model.WiningTypeCount;

public class OutputView {

    private static final String OUTPUT_THREE_BAR = "---\n";
    private static final String OUTPUT_BAR = "- ";
    private static final String NEW_LINE = "\n";
    private static final String OUTPUT_BUYING_LOTTO = "8개를 구매했습니다.\n";
    private static final String OUTPUT_WINING_HEADER = "당첨 통계\n";
    private static final String OUTPUT_WINING_CORRECT_COUNT = "%d개 일치";
    private static final String OUTPUT_HAS_BONUS = ", 보너스 볼 일치";
    private static final String OUTPUT_WINING_AMOUNT = " (%,d원) ";
    private static final String OUTPUT_WINING_COUNT = "%d개";
    private static final String OUTPUT_RATE_OF_RETUN = "총 수익률은 %s%%입니다.";


    public void printBuyingLotto(List<Lotto> lottos) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE);
        stringBuffer.append(OUTPUT_BUYING_LOTTO);
        lottos.forEach(lotto -> stringBuffer.append(lotto.getNumbers() + NEW_LINE));
        System.out.println(stringBuffer);
    }

    public void printWiningStatistics(WiningStatistics statistics) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE);
        stringBuffer.append(OUTPUT_WINING_HEADER);
        stringBuffer.append(OUTPUT_THREE_BAR);
        WiningTypeCount winingTypeCount = statistics.getWiningTypeCount();
        for (WiningType winingType : WiningType.winingCountToMap().keySet()) {
            addWiningCountString(winingType, stringBuffer, winingTypeCount);
        }
        stringBuffer.append(String.format(OUTPUT_RATE_OF_RETUN, statistics.getRateOfReturn()));
        System.out.println(stringBuffer);
    }

    private void addWiningCountString(WiningType winingType, StringBuffer stringBuffer
            , WiningTypeCount winingTypeCount) {
        if (winingType == WiningType.ZERO) {
            return;
        }

        stringBuffer.append(String.format(OUTPUT_WINING_CORRECT_COUNT, winingType.getCorrectCount()));
        if (winingType.hasBonus()) {
            stringBuffer.append(OUTPUT_HAS_BONUS);
        }
        stringBuffer.append(String.format(OUTPUT_WINING_AMOUNT, winingType.getAmount()));
        stringBuffer.append(OUTPUT_BAR);
        stringBuffer.append(String.format(OUTPUT_WINING_COUNT, winingTypeCount.getWiningCount(winingType)));
        stringBuffer.append(NEW_LINE);
    }
}
