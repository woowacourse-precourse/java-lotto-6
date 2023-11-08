package lotto.result;

import java.util.Map;
import lotto.Grade;
import lotto.util.message.OutputMessage;

public class StatisticsProcessor {

    public void getStatistics(Map<Grade, Integer> map) {
        OutputMessage.winningStatistics(map);
    }
}
