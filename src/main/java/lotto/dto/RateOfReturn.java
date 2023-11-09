package lotto.dto;

public class RateOfReturn {


    private final float rateOfReturn;

    private RateOfReturn(float rateOfReturn) {

        this.rateOfReturn = rateOfReturn;

    }

    public static RateOfReturn from(long expense, long revenue) {

        return new RateOfReturn((float) revenue * 100 / expense);

    }

    public float show() {

        return rateOfReturn;

    }
}
