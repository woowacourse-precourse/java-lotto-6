package lotto.model.constant;

public enum LottoConstant {

    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    LOTTO_PRICE(1000),
    LOTTO_NUMBER_SIZE(6);


    private final int constant;

    LottoConstant(int constant){
        this.constant=constant;
    }

    public int getConstant(){return constant;}
}
