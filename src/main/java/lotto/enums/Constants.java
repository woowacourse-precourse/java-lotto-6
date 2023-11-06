package lotto.enums;

public enum Constants {
    LOTTO_PRICE(1000)
    ;

    private int number;

    Constants(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
