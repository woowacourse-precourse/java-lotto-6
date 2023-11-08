package lotto.constant;

public enum LottoConstant {

    START(1),
    END(45),
    LENGTH(6);


    private final int number;

    LottoConstant(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
