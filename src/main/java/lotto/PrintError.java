package lotto;

public class PrintError {
    private static final String INPUT_NULL_ERROR = "[ERROR] 아무것도 입력하지 않았습니다.";
    private static final String INPUT_DECIMAL_ERROR = "[ERROR] 금액을 올바르게 다시 입력하세요(양의 정수)";
    private static final String INPUT_PRICE_ERROR = "[ERROR] 금액을 1000원 단위로 입력해 주세요";
    private static final String INPUT_DUPLICATE_ERROR = "[ERROR] 중복된 번호가 입력되었습니다.";
    private static final String INPUT_RANGE_ERROR = "[ERROR] 유효하지 않은 로또 번호입니다.(1~45)";
    private static final String INPUT_COUNT_ERROR = "[ERROR] 올바른 개수에 맞춰 입력해 주세요";


    public static String nullException(){
        return INPUT_NULL_ERROR;
    }

    public static String decimalException(){
        return INPUT_DECIMAL_ERROR;
    }

    public static String priceError(){
        return INPUT_PRICE_ERROR;
    }

    public static String duplicateError(){
        return INPUT_DUPLICATE_ERROR;
    }

    public static String rangeError(){
        return INPUT_RANGE_ERROR;
    }

    public static String countERROR(){
        return INPUT_COUNT_ERROR;
    }

}
