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
        int[] matchCounts = new int[7];
        //매치 수에 따라 배열에 저장
        matchCounts[numberOfMatches]++;
        //2등인 경우
        if (numberOfMatches == 5 && bonusNumberMatches) {
            numberOfSecond += matchCounts[5];
            matchCounts[5]--;
        }
        numberOfFirst += matchCounts[6];
        numberOfThird += matchCounts[5];
        numberOfFourth += matchCounts[4];
        numberOfFifth += matchCounts[3];
    }
}
