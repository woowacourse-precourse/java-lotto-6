package lotto.validator;

public class LottoValidator {
    private static final String AMOUNT_INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력할 수 있습니다";
    private static final String AMOUNT_INPUT_CORRECT_AMOUNT_EXCEPTION_MESSAGE = "1000원 단위로 입력할 수 있습니다.";
    private static final String AMOUNT_INPUT_EMPTY_EXCEPTION_MESSAGE = "숫자를 입력해주세요";


    public static boolean amountInputValidator(String amount){
        return amountInputOnlyNumberValidator(amount) &&
                amountInputRangeValidator(amount) &&
                amountInputEmptyValidator(amount);
    }
    private static boolean amountInputOnlyNumberValidator(String amount){
        try{
            Integer.parseInt(amount);
            return true;
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_INPUT_ONLY_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private static boolean amountInputEmptyValidator(String amount){
        if( amount.length() ==0 ){
            throw new IllegalArgumentException(AMOUNT_INPUT_EMPTY_EXCEPTION_MESSAGE);
        }
        return true;
    }
    private static boolean amountInputRangeValidator(String amount){
        if( Integer.parseInt(amount) % 1000 != 0  || amount.equals("0")){
            throw new IllegalArgumentException(AMOUNT_INPUT_CORRECT_AMOUNT_EXCEPTION_MESSAGE);
        }
        return true;
    }


}
