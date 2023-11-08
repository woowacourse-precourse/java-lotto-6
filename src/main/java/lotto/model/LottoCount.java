package lotto.model;

public class LottoCount {
    private static final int LOTTO_COST = 1000;

    public int inputLottoCost(int inputCost) {
        validateLottoCost(inputCost);
        return calculateLottoCount(inputCost);
    }

    private int calculateLottoCount(int inputCost) {
        return inputCost / LOTTO_COST;
    }

    private void validateLottoCost(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위의 숫자가 아닙니다.");
        }
    }

}
