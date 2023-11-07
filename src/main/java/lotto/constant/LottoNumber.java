package lotto.constant;

public enum LottoNumber {
    FIRST_PRIZE_MONEY(2000000000),
    SECOND_PRIZE_MONEY(30000000),
    THIRD_PRIZE_MONEY(1500000),
    FOURTH_PRIZE_MONEY(50000),
    FIFTH_PRIZE_MONEY(5000),
    NUMBER_NEEDED_FOR_FIRST(6),
    NUMBER_NEEDED_FOR_SECOND(5),
    NUMBER_NEEDED_FOR_THIRD(5),
    NUMBER_NEEDED_FOR_FOURTH(4),
    NUMBER_NEEDED_FOR_FIFTH(3),
    MINIMUM_LOTTO_NUMBER(1),
    MAXIMUM_LOTTO_NUMBER(45),
    NUMBER_OF_REQUIRED_LOTTO_NUMBER(6),
    NUMBER_OF_REQUIRED_BONUS_NUMBER(1),
    PRICE_PER_LOTTO(1000),
    INITIAL_RATE_OF_RETURN(100);
    
    private final int lottoNumber;

    LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
