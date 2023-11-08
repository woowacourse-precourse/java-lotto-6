package lotto.model;

import static lotto.config.RuleConfig.BASE_LOTTO_PRICE;
import static lotto.config.RuleConfig.MAX_LOTTO_COUNT;

import lotto.utils.ErrorMessages;


public class LottoPurchaseManager {
    private final int trial;

    private LottoPurchaseManager(String moneyAfterValidated){
        int money = Integer.parseInt(moneyAfterValidated);
        this.trial = money / BASE_LOTTO_PRICE;
    }

    public static LottoPurchaseManager createLottoPurchaseManager(String moneyBeforeValidated){
        validateMoney(moneyBeforeValidated);
        return new LottoPurchaseManager(moneyBeforeValidated);
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
        if(isShortOfMoney(parsedMoney)){
            throw new IllegalStateException(ErrorMessages.NO_MONEY.toString());
        }
        if(exceedsMaxTrial(parsedMoney)){
            throw new IllegalArgumentException(ErrorMessages.TOO_MANY_LOTTOS.toString());
        }
        if(isNotInBaseUnit(parsedMoney)){
            throw new IllegalArgumentException(ErrorMessages.UNIT_BASE_PRICE.toString());
        }
    }

    private static boolean isShortOfMoney(int parsedMoney){
        return parsedMoney <= 0;
    }

    private static boolean exceedsMaxTrial(int parsedMoney){
        return parsedMoney > MAX_LOTTO_COUNT * BASE_LOTTO_PRICE;
    }

    private static boolean isNotInBaseUnit(int parsedMoney){
        return parsedMoney % BASE_LOTTO_PRICE > 0;
    }
}
