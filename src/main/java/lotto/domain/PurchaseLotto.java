package lotto.domain;

import java.util.List;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private int quantity;
    private int purchaseMoney;
    private List<Lotto> purchasedLottos;

    public PurchaseLotto(int purchaseMoney){
        validate(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
        this.quantity = calculatePurchasedQuantity(purchaseMoney);
        this.purchasedLottos = getLottos();
    }

    public int getQuantity(){
        return quantity;
    }

    public List<Lotto> getPurchasedLottos(){
        return purchasedLottos;
    }

    public int getPurchaseMoney(){
        return purchaseMoney;
    }

    private void validate(int purchaseMoney){
        isOverZero(purchaseMoney);
        isMultipleOfLottoPrice(purchaseMoney);
    }

    private void isOverZero(int input){
        if(input <= 0){
            throw new IllegalArgumentException();
        }
    }

    private void isMultipleOfLottoPrice(int input){
        if(input % LOTTO_PRICE != 0){
            throw new IllegalArgumentException();
        }
    }

    private int calculatePurchasedQuantity(int purchaseMoney){
        return purchaseMoney / LOTTO_PRICE;
    }

    private List<Lotto> getLottos(){
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.generateLottos(quantity);
    }
}
