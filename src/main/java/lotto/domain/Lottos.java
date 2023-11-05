package lotto.domain;

import lotto.errors.ErrorMessage;

public class Lottos {

    private int numberOfLottos;

    public Lottos(String cost) {
        this.numberOfLottos = calculateNumberOfLottos(parseIntCost(cost));
    }

    private int parseIntCost(String cost){
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_NUMBER_FORMAT.getMessage());
        }
    }

    private int calculateNumberOfLottos(int cost){
        if (cost%1000!=0) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_COST.getMessage());
        }
        return cost/1000;
    }
}
