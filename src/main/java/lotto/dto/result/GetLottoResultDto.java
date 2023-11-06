package lotto.dto.result;

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

    private final int getThreeHit() {
        return threeHit;
    }

    private final int getFourHit() {
        return fourHit;
    }

    private final int getFiveHit() {
        return fiveHit;
    }

    private final int getFiveHitWithBonus() {
        return fiveHitWithBonus;
    }

    private final int getSixHit() {
        return sixHit;
    }
    public int threeHit(){
        return getThreeHit();
    }
    public int fourHit(){
        return getFourHit();
    }
    public int fiveHit(){
        return getFiveHit();
    }
    public int fiveHitWithBonus(){
        return getFiveHitWithBonus();
    }
    public int sixHit(){
        return getSixHit();
    }
}
