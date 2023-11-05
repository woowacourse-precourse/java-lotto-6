package lotto.domain;

public class Lottos {

    private int numberOfLottos;

    public Lottos(String cost) {
        this.numberOfLottos = calculateNumberOfLottos(parseIntCost(cost));
    }

    private int parseIntCost(String cost){
        return Integer.parseInt(cost);
    }

    private int calculateNumberOfLottos(int cost){
        if (cost%1000!=0) {
            throw new IllegalArgumentException();
        }
        return cost/1000;
    }
}
