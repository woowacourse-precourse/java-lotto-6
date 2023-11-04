package lotto.domain;

public class BonusLottoNum {
    private int bonusNum;

    public int getBonusNum() {
        return 0;
    }

    private void validateBonusLottoNum() {

    }

    private boolean isInRange() {
        return 1 <= bonusNum && bonusNum <= 45;
    }

    private void checkRange() {
        if (isInRange()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isDuplicateWinningNumbers(){
        return true;
    }

    private void checkDuplicateWinningNumbers(){

    }
}
