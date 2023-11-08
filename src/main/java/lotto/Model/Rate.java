package lotto.Model;

public class Rate {
    int totalPrize;

    public Rate(Result result) {
        this.totalPrize = setTotalPrize(result);
    }

    public double calculateWinningRate(Price price) {
        return price.makeWinningRate(this.totalPrize);
    }

    private int setTotalPrize(Result result) {
        return result.calculateTotalPrize();
    }
}
