package lotto.domain;

import lotto.errors.ErrorMessage;
import lotto.output.OutputView;

public class LottoManager {
    private int numberOfLottos;

    public void setNumberOfLottos(String cost) {
        int integerCost = parseIntCost(cost);
        isZero(integerCost);
        calculateNumberOfLottos(integerCost);
        this.numberOfLottos = integerCost/1000;
    }

    private int parseIntCost(String cost){
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        }
    }

    private void isZero(int cost){
        if (cost==0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ZERO.getMessage());
        }
    }

    private void calculateNumberOfLottos(int cost){
        if (cost%1000!=0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_COST.getMessage());
        }
    }

    public boolean checkNumberOfLottos() {
        return this.numberOfLottos>0;
    }

    public String printOutNumberOfLottos() {
        return this.numberOfLottos + OutputView.NUMBER_OF_LOTTOS.getMessage();
    }
}
