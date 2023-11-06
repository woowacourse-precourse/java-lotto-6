package lotto.domain;

public class LottoPublisher{

    private static final int UNIT = 1000;

    public int getLottoCountByAmount(int amount){
        return amount/UNIT;
    }

}
