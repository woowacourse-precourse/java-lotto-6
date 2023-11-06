package lotto.model;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.MAX_LOTTO_COUNT;

import lotto.utils.ErrorMessages;


public class LottoPurchaseManager {
    private int trial;
    private int money;
    private LottoPurchaseManager(String money){
        this.money = Integer.parseInt(money);
        this.trial = this.money / BASE_LOTTO_PRICE;
    }
    public static LottoPurchaseManager createLottoPurchaseManager(String money){
        validateMoney(money);
        return new LottoPurchaseManager(money);
    }
    public int getTrial(){
        return this.trial;
    }

    private static void validateMoney(String money){
        int parsedMoney;
        try{
            parsedMoney = Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalStateException(ErrorMessages.NOT_INTEGER.toString());
        }
        if(parsedMoney <= 0){
            throw new IllegalStateException(ErrorMessages.NO_MONEY.toString());
        }
        if(parsedMoney > MAX_LOTTO_COUNT * BASE_LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessages.TOO_MANY_LOTTOS.toString());
        }
        if(parsedMoney % BASE_LOTTO_PRICE > 0){
            throw new IllegalArgumentException(ErrorMessages.UNIT_BASE_PRICE.toString());
        }
    }
}
