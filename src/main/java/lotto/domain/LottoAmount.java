package lotto.domain;

public class LottoAmount {
    private static final int LOTTO_PRICE=1000;
    private final int amount;

    public LottoAmount(int amount){
        this.amount =amount;
    }

    public int calcLottoNum(){
        return amount /LOTTO_PRICE;
    }
}
