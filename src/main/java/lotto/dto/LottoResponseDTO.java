package lotto.dto;

public class LottoResponseDTO {
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;
    private double rateOfReturn;

    public LottoResponseDTO(){
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;
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
