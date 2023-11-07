package lotto.values;

public enum EarningInformation {
    EARNING_FIFTH(5000),
    EARNING_FOURTH(50000),
    EARNING_THIRD(1500000),
    EARNING_SECOND(30000000),
    EARNING_FIRST(2000000000);

    private final double value;
    EarningInformation(double value){
        this.value = value;
    }

    public double getValue(){
        return value;
    }
}
