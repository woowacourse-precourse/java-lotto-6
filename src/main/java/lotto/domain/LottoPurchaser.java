package lotto.domain;

import lotto.output.OutputView;

public class LottoPurchaser extends Validator{

    private static LottoPurchaser lottoPurchaser;

    private int numberOfLottos;

    private LottoPurchaser() {}

    public static LottoPurchaser getInstance() {
        if (lottoPurchaser ==null) {
            lottoPurchaser = new LottoPurchaser();
        }
        return lottoPurchaser;
    }

    public int getNumberOfLottos() {
        return numberOfLottos;
    }

    public void setNumberOfLottos(String cost) {
        int integerCost = parseInt(cost);
        isSmallerthanZero(integerCost);
        calculateNumberOfLottos(integerCost);
        this.numberOfLottos = integerCost/1000;
    }

    public boolean checkNumberOfLottos() {
        return this.numberOfLottos>0;
    }

    public String printOutNumberOfLottos() {
        return this.numberOfLottos + OutputView.NUMBER_OF_LOTTOS.getMessage();
    }


}
