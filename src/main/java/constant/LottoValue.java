package constant;

public enum LottoValue {
    LOTTO_SIZE(6),
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45);
    
    private final int value;

    LottoValue(int value){
        this.value = value;
    }

    public int value(){
        return value;
    }

}
