package lotto.Domain.Constants;

public enum LottoRules {
    MAX_LOTTO_BALL_RANGE(45),
    MIN_LOTTO_BALL_RANGE(1),
    TOTAL_BALL_NUMBERS(6),
    GAME_FEE(1000);

    private final int number;

    LottoRules(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
