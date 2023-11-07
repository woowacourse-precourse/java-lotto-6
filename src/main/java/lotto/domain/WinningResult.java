package lotto.domain;

public class WinningResult {

    private Integer numberOfFirst = 0;
    private Integer numberOfSecond = 0;
    private Integer numberOfThird = 0;
    private Integer numberOfFourth = 0;
    private Integer numberOfFifth = 0;

    public Integer getNumberOfFirst() {
        return this.numberOfFirst;
    }

    public Integer getNumberOfSecond() {
        return numberOfSecond;
    }

    public Integer getNumberOfThird() {
        return numberOfThird;
    }

    public Integer getNumberOfFourth() {
        return numberOfFourth;
    }

    public Integer getNumberOfFifth() {
        return numberOfFifth;
    }

    public void addResults(int numberOfMatches, boolean bonusNumberMatches) {
        if (numberOfMatches == 6) {
            numberOfFirst++;
        } else if (numberOfMatches == 5 && bonusNumberMatches) {
            numberOfSecond++;
        } else if (numberOfMatches == 5) {
            numberOfThird++;
        } else if (numberOfMatches == 4) {
            numberOfFourth++;
        } else if (numberOfMatches == 3) {
            numberOfFifth++;
        }
    }
}
