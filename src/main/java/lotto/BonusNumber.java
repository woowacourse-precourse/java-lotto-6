package lotto;

public class BonusNumber {
    private int number;

    public BonusNumber() {
        number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(Lotto lotto, int bonusNumber) {
        checkDuplicationWithBonus(lotto, bonusNumber);
        checkRange(bonusNumber);
        number = bonusNumber;
    }

    private static void checkDuplicationWithBonus(Lotto lotto, int bonusNumber) {
        if (lotto.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    private static void checkRange(int number) {
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
