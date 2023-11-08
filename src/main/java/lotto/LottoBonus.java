package lotto;

public class LottoBonus {
    private static final String ERROR_MESSAGE = "[ERROR]";

    protected final int bonus;

    public LottoBonus (int bonus) {
        validateRange(bonus);
        this.bonus = bonus;
    }

    private void validateRange(int bonus) {
        if (bonus < 1 || bonus > 45) {
            System.out.println(ERROR_MESSAGE + " 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
