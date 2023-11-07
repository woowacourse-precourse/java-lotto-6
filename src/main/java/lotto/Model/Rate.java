package lotto.Model;

public class Rate {
    int totalPrize;

    public Rate(Result result) {
        this.totalPrize = calculate(result);
    }

    public double calculateWinningRate(Price price) {
        return price.makeWinningRate(this.totalPrize);
    }

    private int calculate(Result result) {
        return result.calculateTotalWinningPrize();
    }
}
