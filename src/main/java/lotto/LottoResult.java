package lotto;

public class LottoResult {
    private Integer numberOfMatch;
    private Boolean bonus;

    public LottoResult(Integer numberOfMatch, Boolean bonus){
        this.numberOfMatch = numberOfMatch;
        this.bonus = bonus;
    }

    public Integer getNumberOfMatch() {
        return numberOfMatch;
    }

    public Boolean getBonus() {
        return bonus;
    }
}
