package lotto.dto;

import static lotto.etc.RuleConstant.ZERO;

public class CountScoreResponseDTO {
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;
    private double rateOfReturn;

    public CountScoreResponseDTO(){
        this.firstPlace = ZERO.toInt();
        this.secondPlace = ZERO.toInt();
        this.thirdPlace = ZERO.toInt();
        this.fourthPlace = ZERO.toInt();
        this.fifthPlace = ZERO.toInt();
    }

    public void plusFirstPlace(){
        firstPlace++;
    }
    public void plusSecondPlace(){
        secondPlace++;
    }
    public void plusThirdPlace(){
        thirdPlace++;
    }
    public void plusFourthPlace(){
        fourthPlace++;
    }
    public void plusFifthPlace(){
        fifthPlace++;
    }
    public void setRateOfReturn(double rateOfReturn){
        this.rateOfReturn = rateOfReturn;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getFifthPlace() {
        return fifthPlace;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

}
