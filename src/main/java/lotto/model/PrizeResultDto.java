package lotto.model;

public class PrizeResultDto {

    private final int[] prizeCount;
    private final int totalPrize;

    public PrizeResultDto(int[] prizeCount, int totalPrize) {
        this.prizeCount = prizeCount;
        this.totalPrize = totalPrize;
    }

    public static PrizeResultDto of(int[] prizeCount, int totalPrize) {
        return new PrizeResultDto(prizeCount, totalPrize);
    }

    public int[] getPrizeCount() {
        return prizeCount;
    }

    public int getTotalPrize() {
        return totalPrize;
    }

}
