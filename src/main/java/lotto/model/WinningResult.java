package lotto.model;

public class WinningResult {
    private final int firstPlaceCount;
    private final int secondPlaceCount;
    private final int thirdPlaceCount;
    private final int fourthPlaceCount;
    private final int fifthPlaceCount;


    private WinningResult(
            int firstPlaceCount,
            int secondPlaceCount,
            int thirdPlaceCount,
            int fourthPlaceCount,
            int fifthPlaceCount
    ) {
        this.firstPlaceCount = firstPlaceCount;
        this.secondPlaceCount = secondPlaceCount;
        this.thirdPlaceCount = thirdPlaceCount;
        this.fourthPlaceCount = fourthPlaceCount;
        this.fifthPlaceCount = fifthPlaceCount;
    }

    public static WinningResult create() {
        return new WinningResult(0, 0, 0, 0, 0);
    }

    public WinningResult withIncreasedFirstPlaceCount() {
        return new WinningResult(
                this.firstPlaceCount + 1,
                this.secondPlaceCount,
                this.thirdPlaceCount,
                this.fourthPlaceCount,
                this.fifthPlaceCount
        );
    }

    public WinningResult withIncreasedSecondPlaceCount() {
        return new WinningResult(
                this.firstPlaceCount,
                this.secondPlaceCount + 1,
                this.thirdPlaceCount,
                this.fourthPlaceCount,
                this.fifthPlaceCount
        );
    }

    public WinningResult withIncreasedThirdPlaceCount() {
        return new WinningResult(
                this.firstPlaceCount,
                this.secondPlaceCount,
                this.thirdPlaceCount + 1,
                this.fourthPlaceCount,
                this.fifthPlaceCount
        );
    }

    public WinningResult withIncreasedFourthPlaceCount() {
        return new WinningResult(
                this.firstPlaceCount,
                this.secondPlaceCount,
                this.thirdPlaceCount,
                this.fourthPlaceCount + 1,
                this.fifthPlaceCount
        );
    }

    public WinningResult withIncreasedFifthPlaceCount() {
        return new WinningResult(
                this.firstPlaceCount,
                this.secondPlaceCount,
                this.thirdPlaceCount,
                this.fourthPlaceCount,
                this.fifthPlaceCount + 1
        );
    }

    public int getFirstPlaceCount() {
        return firstPlaceCount;
    }

    public int getSecondPlaceCount() {
        return secondPlaceCount;
    }

    public int getThirdPlaceCount() {
        return thirdPlaceCount;
    }

    public int getFourthPlaceCount() {
        return fourthPlaceCount;
    }

    public int getFifthPlaceCount() {
        return fifthPlaceCount;
    }
}
