package lotto.model;

public record PrizePercentage(
        double prizePercentage
) {

    public String getPrizePercentage() {
        return String.format("%.1f", prizePercentage) + "%";
    }
}
