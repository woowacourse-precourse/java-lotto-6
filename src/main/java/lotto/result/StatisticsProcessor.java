package lotto.result;

import java.util.Map;
import lotto.util.message.OutputMessage;

public class StatisticsProcessor {

    public void getStatistics(Map<Grade, Integer> resultMap) {
        OutputMessage.winningStatistics(resultMap);
    }
}
