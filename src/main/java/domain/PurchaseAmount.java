package domain;

import util.ExceptionMessage;

import static util.ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER;

/**
 * packageName    : domain
 * fileName       : PurchaseAmount
 * author         : qkrtn_ulqpbq2
 * date           : 2023-11-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-06        qkrtn_ulqpbq2       최초 생성
 */
public class PurchaseAmount {

    private static final int ZERO = 0;
    private static final int ONE_THOUSAND = 1000;
    private static final String COMMA = ",";
    private static final String NULL = "";
    private final int amount;
    private final int numberOfLottoPurchased;

    public int getNumberOfLottoPurchased(){
        return numberOfLottoPurchased;
    }

    public int getAmount(){
        return amount;
    }
    public PurchaseAmount(String amount){
        amount = removeSeparatorChar(amount);
        validate(amount);
        this.amount = convertStringToInt(amount);
        this.numberOfLottoPurchased = calculateNumberOfLottoPurchasesByAmount(this.amount);
    }

    private String removeSeparatorChar(String amount){
        return amount.replaceAll(COMMA, NULL);
    }

    private void validate(String amount){
        isStringEmpty(amount);
        isStringDigit(amount);
        isExceedZero(amount);
        isThousandUnits(amount);
    }

    private void isStringEmpty(String amount){
        if(amount == null || amount.isBlank()){
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.throwException();
        }
    }

    private void isStringDigit(String amount){
        if(!amount.chars().allMatch(Character::isDigit)){
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.throwException();
        }
    }

    private void isExceedZero(String amount){
        if(convertStringToInt(amount) <= ZERO){
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_EXCEED_ZERO.throwException();
        };
    }

    private int convertStringToInt(String amount) {
        return Integer.parseInt(amount);
    }

    private void isThousandUnits(String amount){
        if(convertStringToInt(amount) % ONE_THOUSAND != ZERO){
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNITS.throwException();
        }
    }

    private int calculateNumberOfLottoPurchasesByAmount(int amount){
        return amount / ONE_THOUSAND;
    }
}
