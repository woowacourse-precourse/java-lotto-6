package lotto.entity;

public class LottoResult {
    private Integer numberOf_3Correction;
    private Integer numberOf_4Correction;
    private Integer numberOf_5Correction;
    private Integer numberOf_5CorrectionAndBonus;

    private Integer numberOf_6Correction;

    private Double profitRate;

    public LottoResult() {
        this.numberOf_3Correction = 0;
        this.numberOf_4Correction = 0;
        this.numberOf_5Correction = 0;
        this.numberOf_5CorrectionAndBonus = 0;
        this.numberOf_6Correction = 0;
        this.profitRate = 0.0;
    }

    public void plusOne_3Correction() {
        this.numberOf_3Correction++;
    }

    public void plusOne_4Correction() {
        this.numberOf_4Correction++;
    }

    public void plusOne_5Correction() {
        this.numberOf_5Correction++;
    }

    public void plusOne_5CorrectionAndBonus() {
        this.numberOf_5CorrectionAndBonus++;
    }

    public void plusOne_6Correction() {
        this.numberOf_6Correction++;
    }

    public double getProfitRate(Integer inputMoney) {

        Integer totalPrice = numberOf_3Correction * Price.CORRECTION_3.getPrice()
                + numberOf_4Correction * Price.CORRECTION_4.getPrice()
                + numberOf_5Correction * Price.CORRECTION_5.getPrice()
                + numberOf_5CorrectionAndBonus * Price.CORRECTION_5_BONUS.getPrice()
                + numberOf_6Correction * Price.CORRECTION_6.getPrice();

        double profit = (double) totalPrice / inputMoney * 100;
        double profitRate = (double) Math.round(profit / 100);

        this.profitRate = profitRate;
        return this.profitRate;
    }
}
