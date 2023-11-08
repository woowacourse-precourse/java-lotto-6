package lotto.model;

public class Rank {
    private int firstPlace = 0;
    private int secondPlace = 0;
    private int thirdPlace = 0;
    private int fourthPlace = 0;
    private int fifthPlace = 0;
    private int totalWinningAmount = 0;

    public void addFirstPlace() {
        firstPlace += 1;
    }

    public void addSecondPlace() {
        secondPlace += 1;
    }

    public void addThirdPlace() {
        thirdPlace += 1;
    }

    public void addFourthPlace() {
        fourthPlace += 1;
    }

    public void addFifthPlace() {
        fifthPlace += 1;
    }
}
