package lotto.domain;

public class CorrectCount {
    
    private int correctNumberCount;
    private int correctBonusNumberCount;

    public CorrectCount(int correctNumberCount, int correctBonusNumberCount) {
        this.correctNumberCount = correctNumberCount;
        this.correctBonusNumberCount = correctBonusNumberCount;
    }

    public int getCorrectNumberCount() {
        return correctNumberCount;
    }

    public int getCorrectBonusNumberCount(){
        return correctBonusNumberCount;
    }
}
