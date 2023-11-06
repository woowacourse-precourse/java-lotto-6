package lotto.model;


public class LottoResultModel {
    private String totalReturnRate;
    private String threeMatch;
    private String fourMatch;
    private String fiveMatch;
    private String fiveBonusMatch;
    private String sixMatch;

    public void setTotalReturnRate(String totalReturnRate) {
        this.totalReturnRate = totalReturnRate;
    }

    public void setThreeMatch(String threeMatch) {
        this.threeMatch = threeMatch;
    }

    public void setFourMatch(String fourMatch) {
        this.fourMatch = fourMatch;
    }

    public void setFiveMatch(String fiveMatch) {
        this.fiveMatch = fiveMatch;
    }

    public void setFiveBonusMatch(String fiveBonusMatch) {
        this.fiveBonusMatch = fiveBonusMatch;
    }

    public void setSixMatch(String sixMatch) {
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
