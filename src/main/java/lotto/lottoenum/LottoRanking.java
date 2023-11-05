package lotto.lottoenum;

public enum LottoRanking {
    FIRST(6), SECOND(5), THIRD(5), FOURTH(4), FIFTH(3), DEFAULT(0);

    private final int value;
    LottoRanking(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
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
