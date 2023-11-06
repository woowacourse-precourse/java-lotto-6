package domain;

import java.util.List;

public class PrizeNumber {
    private static PrizeNumber instance;
    private List<Integer> prizeNumber;

    private PrizeNumber() {}

    public static PrizeNumber getInstance() {
        if (instance == null) {
            instance = new PrizeNumber();
        }
        return instance;
    }

    public List<Integer> getPrizeNumber() {
        return prizeNumber;
    }

    public void setPrizeNumber(List<Integer> prizeNumber) {
        this.prizeNumber = prizeNumber;
    }
}
