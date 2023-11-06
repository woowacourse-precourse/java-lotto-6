package lotto.domain;

import java.util.List;

public class Result {

    private int firstPrize;
    private int secondPrize;
    private int thirdPrize;
    private int fourthPrize;
    private int fifthPrize;

    public Result() {
        this.firstPrize = 0;
        this.secondPrize = 0;
        this.thirdPrize = 0;
        this.fourthPrize = 0;
        this.fifthPrize = 0;
    }

    public void setResult(List<Prize> prizes) {
        for (Prize prize : prizes) {
            if (prize.getRank() == 1) {
                firstPrize += 1;
            } else if (prize.getRank() == 2) {
                secondPrize += 1;
            } else if (prize.getRank() == 3) {
                thirdPrize += 1;
            } else if (prize.getRank() == 4) {
                fourthPrize += 1;
            } else if (prize.getRank() == 5) {
                fifthPrize += 1;
            }
        }
    }

    public int[] getResult() {
        return new int[]{fifthPrize,fourthPrize,thirdPrize,secondPrize,firstPrize};
    }
}
