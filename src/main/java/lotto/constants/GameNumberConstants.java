package lotto.constants;

public enum GameNumberConstants {
    LOTTO_PRICE(1000);

    private final int value;

    GameNumberConstants(int value){
        this.value = value;

    }

    public int getValue(){
        return value;
    }
}
