package lotto;

public class Lottos {

    private int numberOfLottos;

    public Lottos(String cost) {
        this.numberOfLottos = validateCost(parseIntCost(cost));
    }

    private int parseIntCost(String cost){
        return Integer.parseInt(cost);
    }

    private int validateCost(int cost){
        if (cost%1000!=0) {
            throw new IllegalArgumentException();
        }
        return cost/1000;
    }
}
