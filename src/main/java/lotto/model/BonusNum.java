package lotto.model;

public class BonusNum {
    public int bonusNum;

    public BonusNum(String bonusNum) {
        validateCorrectStringNum(bonusNum);
        validateCorrectStringRange(bonusNum);
        this.bonusNum =  Integer.parseInt(bonusNum);
    }

    private void validateCorrectStringRange(String s) {
        if(Integer.parseInt(s)>=1 && Integer.parseInt(s)<=45){
            throw new IllegalArgumentException();
        }
    }

    private void validateCorrectStringNum(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
