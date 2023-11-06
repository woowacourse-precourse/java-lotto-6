package lotto.model;

import java.util.Map;

public class WiningStatistics {

    private double rateOfReturn;
    private Map<WiningType, Integer> winingCountMap;

    public WiningStatistics(double rateOfReturn, Map<WiningType, Integer> winingCountMap) {
        this.rateOfReturn = rateOfReturn;
        this.winingCountMap = winingCountMap;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        winingCountMap.forEach((winingType, count) -> {
            stringBuffer.append(winingType.getCorrectCount() + "개 일치 ");
            stringBuffer.append("(" + winingType.getAmount() + "원) - ");
            stringBuffer.append(winingCountMap.get(winingType) + "개\n");
        });
        stringBuffer.append("총 수익률은 " + rateOfReturn + "%입니다.");
        return stringBuffer.toString();
    }
}
