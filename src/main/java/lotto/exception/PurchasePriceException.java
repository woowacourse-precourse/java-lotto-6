package lotto.exception;

import lotto.constant.ExceptionConstants;
import lotto.constant.GameConstants;

public class PurchasePriceException {
    public static void validateOnlyNumeric(String purchasePrice){
        if(!purchasePrice.matches("^[0-9]+$")){
            throw new IllegalArgumentException(ExceptionConstants.ERROR_NON_NUMERIC_INPUT);
        }
    }
    //INT 범위를 벗어날때
    public static void validateNumberInRangeIntMax(String purchasePrice){
        try{
            int price = Integer.parseInt(purchasePrice);
            }catch(NumberFormatException e){
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_INPUT_NOT_LESS_THAN_LOTTO_PRICE, GameConstants.MAX_PURCHASE_PRICE));
        }
    }
    //INT 범위를 벗어나지 않지만 정해진 최대값을 넘어갈때
    public static void validateNumberInRange(int purchasePrice){
        if(purchasePrice > GameConstants.MAX_PURCHASE_PRICE){
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_INPUT_NOT_GREATER_THAN_LOTTO_PRICE, GameConstants.LOTTO_PRICE));
        }
    }
    public static void validateSmallerthanLottoPrice(int purchasePrice){
        if(purchasePrice < GameConstants.LOTTO_PRICE){
            throw new IllegalArgumentException(String.format(ExceptionConstants.ERROR_INPUT_NOT_GREATER_THAN_LOTTO_PRICE, GameConstants.LOTTO_PRICE));
        }
    }
    public static void validateMultipleOfThousand(int purchasePrice){
        if(purchasePrice % GameConstants.LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ExceptionConstants.ERROR_INPUT_NOT_MULTIPLE_OF_THOUSAND);
        }
    }

}
