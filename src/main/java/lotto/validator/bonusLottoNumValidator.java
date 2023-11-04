package lotto.validator;

public class bonusLottoNumValidator {
    private boolean isInRange(int bonusNum) {
        return 1 <= bonusNum && bonusNum <= 45;
    }

    private void checkRange(int bonusNum) {
        if (isInRange(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isDuplicateWinningNumbers(int bonusNum){
        return true;
    }

    private void checkDuplicateWinningNumbers(int bonusNum){

    }
}
