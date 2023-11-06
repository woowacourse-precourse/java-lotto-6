package lotto.dto.calculate;

public class GetLottoResultDto {
    private final int threeHit;
    private final int fourHit;
    private final int fiveHit;
    private final int fiveHitWithBonus;
    private final int sixHit;

    public GetLottoResultDto(int threeHit, int fourHit, int fiveHit, int fiveHitWithBonus, int sixHit) {
        this.threeHit = threeHit;
        this.fourHit = fourHit;
        this.fiveHit = fiveHit;
        this.fiveHitWithBonus = fiveHitWithBonus;
        this.sixHit = sixHit;
    }

    public int getThreeHit() {
        return threeHit;
    }

    public int getFourHit() {
        return fourHit;
    }

    public int getFiveHit() {
        return fiveHit;
    }

    public int getFiveHitWithBounus() {
        return fiveHitWithBonus;
    }

    public int getSixHit() {
        return sixHit;
    }
}
