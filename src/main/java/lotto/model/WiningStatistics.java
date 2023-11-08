package lotto.model;

public class WiningStatistics {

    private final WiningTypeCount winingTypeCount;
    private final double rateOfReturn;

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

}
