package Domain.lotto;

public enum LottoPrice {
    nomal(1000);

    final Integer value;

    LottoPrice(int value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
