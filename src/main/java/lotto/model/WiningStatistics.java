package lotto.model;

public class WiningStatistics {

    private WiningTypeCount winingTypeCount;
    private double rateOfReturn;

    public WiningStatistics(WiningTypeCount winingTypeCount, double rateOfReturn) {
        this.winingTypeCount = winingTypeCount;
        this.rateOfReturn = rateOfReturn;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public WiningTypeCount getWiningTypeCount() {
        return winingTypeCount;
    }

    //    @Override
//    public String toString() {
//        StringBuffer stringBuffer = new StringBuffer();
//        winingCountMap.forEach((winingType, count) -> {
//            stringBuffer.append(winingType.getCorrectCount() + "개 일치");
//            if (winingType.hasBonus()) {
//                stringBuffer.append(", 보너스 볼 일치");
//            }
//            stringBuffer.append(" (" + StringUtils.formatCommaIntegerToString(winingType.getAmount()) + "원) - ");
//            stringBuffer.append(winingCountMap.get(winingType) + "개\n");
//        });
//        stringBuffer.append("총 수익률은 " + rateOfReturn + "%입니다.");
//        return stringBuffer.toString();
//    }
}
