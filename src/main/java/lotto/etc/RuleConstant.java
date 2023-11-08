package lotto.etc;

public enum RuleConstant {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    LOTTO_PRICE(1000),
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COUNT(6),
    SIX_MATCH(6),
    FIVE_MATCH(5),
    FORE_MATCH(4),
    THREE_MATCH(3),
    ZERO(0);
    private int enumInteger;
    RuleConstant(int enumInteger) {
        this.enumInteger = enumInteger;
    }
    public int toInt(){
        return enumInteger;
    }

}
