package lotto.lottoenum;

public enum LottoRanking {
    FIRST(6, 2000000000), SECOND(5, 30000000), THIRD(5,1500000),
    FOURTH(4, 50000), FIFTH(3, 5000), DEFAULT(0, 0);

    private final int value;
    private final int price;
    LottoRanking(int value, int price){
        this.value = value;
        this.price = price;
    }

    public int getValue(){
        return value;
    }
    public int getPrice(){
        return price;
    }
    public LottoRanking findByValue(int value){
        for(LottoRanking lottoRanking: values()){
            if(lottoRanking.value == value){
                return lottoRanking;
            }
        }
        throw new IllegalArgumentException();
    }
}
