package lotto.model;


public class LottoResultModel {
    private String totalReturnRate;
    private String threeMatch;
    private String fourMatch;
    private String fiveMatch;
    private String fiveBonusMatch;
    private String sixMatch;

    public LottoResultModel(String totalReturnRate, String threeMatch, String fourMatch, String fiveMatch, String fiveBonusMatch, String sixMatch) {
        this.totalReturnRate = totalReturnRate;
        this.threeMatch = threeMatch;
        this.fourMatch = fourMatch;
        this.fiveMatch = fiveMatch;
        this.fiveBonusMatch = fiveBonusMatch;
        this.sixMatch = sixMatch;
    }

    public String getTotalReturnRate() {
        return totalReturnRate;
    }

    public String getThreeMatch() {
        return threeMatch;
    }

    public String getFourMatch() {
        return fourMatch;
    }

    public String getFiveMatch() {
        return fiveMatch;
    }

    public String getFiveBonusMatch() {
        return fiveBonusMatch;
    }

    public String getSixMatch() {
        return sixMatch;
    }
}
