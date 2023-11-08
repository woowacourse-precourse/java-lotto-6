package lotto.lottoenum;

public enum LottoRanking {
    FIFTH(3, 5000), FOURTH(4, 50000), THIRD(5,1500000),
    SECOND(5, 30000000), FIRST(6, 2000000000), DEFAULT(0, 0);

    private final int value;
    private final float price;
    LottoRanking(int value, float price){
        this.value = value;
        this.price = price;
    }
    public float getPrice(){
        return price;
    }
    public LottoRanking findByValue(int value){
        for(LottoRanking lottoRanking: values()){
            if(lottoRanking.value == value){
                return lottoRanking;
            }
        }
        return LottoRanking.DEFAULT;
    }
}
