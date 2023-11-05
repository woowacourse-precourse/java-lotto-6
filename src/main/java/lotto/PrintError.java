package lotto;

public class PrintError {
    private static final String INPUT_NULL_ERROR = "[ERROR] 아무것도 입력하지 않았습니다.";
    private static final String INPUT_DECIMAL_ERROR = "[ERROR] 금액을 올바르게 다시 입력하세요(정수)";
    private static final String INPUT_PRICE_ERROR = "[ERROR] 금액을 1000원 단위로 입력해 주세요";
    private static final String INPUT_DUPLICATE_ERROR = "[ERROR] 중복된 번호가 입력되었습니다.";
    private static final String INPUT_RANGE_ERROR = "[ERROR] 유효하지 않은 로또 번호입니다.(1~45)";
    private static final String INPUT_COUNT_ERROR = "[ERROR] 올바른 개수에 맞춰 입력해 주세요";

    public PrintError(){
    }

    private void nullException(){
        System.out.println(INPUT_NULL_ERROR);
    }

    private void decimalException(){
        System.out.println(INPUT_DECIMAL_ERROR);
    }

    private void priceError(){
        System.out.println(INPUT_PRICE_ERROR);
    }

    private void duplicateError(){
        System.out.println(INPUT_DUPLICATE_ERROR);
    }

    private void rangeError(){
        System.out.println(INPUT_RANGE_ERROR);
    }

    private void countERROR(){
        System.out.println(INPUT_COUNT_ERROR);
    }

}
