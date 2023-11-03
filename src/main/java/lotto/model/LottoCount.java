package lotto.model;

public class LottoCount {
    private static final int LOTTO_COST = 1000;

    public int inputLottoCost(int inputCost){
        // validate inputCost
        return calculateLottoCount(inputCost);
    }

    private int calculateLottoCount(int inputCost) {
        return inputCost/LOTTO_COST;
    }
}
