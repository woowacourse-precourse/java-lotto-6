package lotto.validator;

public class BonusLottoNumValidator {
    private boolean isNotInRange(int bonusNum) {
        return bonusNum < 1 || bonusNum > 45;
    }

    public void checkRange(int bonusNum) {
        if (isNotInRange(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isDuplicateWinningNumbers(int bonusNum){
        return true;
    }

    public void checkDuplicateWinningNumbers(int bonusNum){

    }
}
