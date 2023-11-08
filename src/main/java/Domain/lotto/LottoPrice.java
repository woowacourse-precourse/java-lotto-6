package Domain.lotto;
/*
    lotto에 price 필드를 추가할 수 없기에 궁여지책으로 만든 enum
 */
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
