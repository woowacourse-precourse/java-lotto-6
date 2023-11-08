package lotto.Model.ProfitRate;

public class ProfitRate {
    private final Double ProfitRate ;

    public ProfitRate( double profitPercent) {
        this.ProfitRate = profitPercent;
    }


    public Double  getProfitRatePercent(){
        return this.ProfitRate;
    }


}
