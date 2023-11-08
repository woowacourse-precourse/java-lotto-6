package lotto.constant;

public enum Numbers {
    INIT_NUMBER_START(1),
    INIT_NUMBER_END(45),
    INIT_NUMBER_COUNT(6),
    RANK_NUMBER(5);

    private final int number;

    Numbers(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

}
