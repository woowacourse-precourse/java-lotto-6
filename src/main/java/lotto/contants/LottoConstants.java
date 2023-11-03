package lotto.contants;

public enum LottoConstants {
    MAX_NUMBER_OF_LOTTO(45),
    MIN_NUMBER_OF_LOTTO(1),
    LOTTO_NUMBER_COUNT(6);

    final Integer value;

    LottoConstants(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
