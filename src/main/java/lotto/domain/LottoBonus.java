package lotto.domain;

public class LottoBonus {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private final int number;

    public LottoBonus(int number) {
        validate(number);
        this.number = number;
    }

    
}
