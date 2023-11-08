package lotto.model;

public class BonusNum {
    private final int bonusNum;

    public BonusNum(String bonusNum) {
        validateCorrectStringNum(bonusNum);
        validateCorrectStringRange(bonusNum);
        this.bonusNum =  Integer.parseInt(bonusNum);
    }

    private void validateCorrectStringRange(String s) {
        if(Integer.parseInt(s)<1 || Integer.parseInt(s)>45){
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }

    private void validateCorrectStringNum(String s) {
        if (!s.matches("\\d+")) {
            throw new IllegalArgumentException();
        }
    }
}
