package lotto.utility.enums;

public enum Standards {
    ONE_LOTTO_COST(1000),
    ZERO(0);


    private int number;

    Standards(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
