package lotto.domain;

public class RateOfReturnCalculator implements Calculator {

    @Override
    public float calculate(int[] result, int amount) {
        float total = new TotalCalculator().calculate(result, amount) * 1.0f;
        float rateOfResult = (total / (amount * 1000))  * 100.0f;
        return rateOfResult;
    }
}
