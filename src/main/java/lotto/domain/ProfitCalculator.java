package lotto.domain;

public class ProfitCalculator {
    int inputPrice;
    int profit;

    public ProfitCalculator(int inputPrice, int profit) {
        this.inputPrice = inputPrice;
        this.profit = profit;
    }

    public String calculate(){
        double percent = ((double) this.profit / (double) this.inputPrice * 100);
        System.out.println(percent);
        return String.format("%.1f", percent);
    }
}
