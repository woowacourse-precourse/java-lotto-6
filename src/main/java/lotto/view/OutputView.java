package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.WiningStatistics;

public class OutputView {

    private static final String OUTPUT_BUYING_LOTTO = "8개를 구매했습니다.\n";
    private static final String OUTPUT_wining_HEADER = "당첨 통계\n";
    private static final String OUTPUT_THREE_BAR = "---\n";
    private static final String NEW_LINE = "\n";

    public void printBuyingLotto(List<Lotto> lottos) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE);
        stringBuffer.append(OUTPUT_BUYING_LOTTO);
        lottos.forEach(lotto -> stringBuffer.append(lotto.toString() + NEW_LINE));
        System.out.println(stringBuffer.toString());
    }

    public void printWiningStatistics(WiningStatistics statistics) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(NEW_LINE);
        stringBuffer.append(OUTPUT_wining_HEADER);
        stringBuffer.append(OUTPUT_THREE_BAR);
        stringBuffer.append(statistics.toString());
        System.out.println(stringBuffer.toString());
    }
}
