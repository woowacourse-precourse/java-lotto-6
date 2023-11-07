package lotto.domain;

public class TotalCalculator implements Calculator {

    @Override
    public float calculate(int[] result, int amount) {
        float total = 0;

        total+=result[3]*5000;
        total+=result[4]*50000;
        total+=result[5]*1500000;
        total+=result[7]*30000000;
        total+=result[6]*200000000;

        return total;
    }
}
