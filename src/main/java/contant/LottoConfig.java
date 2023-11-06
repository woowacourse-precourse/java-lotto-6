package contant;

public enum LottoConfig {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    COST(1000);

    private final int value;
    LottoConfig(int value){
        this.value = value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}
