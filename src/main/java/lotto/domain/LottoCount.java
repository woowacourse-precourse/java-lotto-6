package lotto.domain;

public class LottoCount {

    private static final int ONE_LOTTO_TICKET_PRICE = 1000;

    private int value;

    public LottoCount(int purchaseMoney){
        this.value = convertLottoCount(purchaseMoney);
    }

    public int getValue(){
        return value;
    }

    private int convertLottoCount(int purchaseMoney){
        return purchaseMoney / ONE_LOTTO_TICKET_PRICE;
    }
}
