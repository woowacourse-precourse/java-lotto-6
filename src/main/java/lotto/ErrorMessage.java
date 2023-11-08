package lotto;

public class ErrorMessage {
    private static final String TYPE_ERROR = "[ERROR]숫자만 입력 가능합니다.";
    private static final String NUMBER_OVER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String AMOUNT_TYPE_ERROR = "[ERROR] 금액은 숫자만 가능합니다.";
    private static final String AMOUNT_NUMBER = "[ERROR] 금액은 천원 단위로 입력해주세요.";
    //private static final String NUMBER_OVER = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void setTypeError() {
        System.out.print(TYPE_ERROR);
    }

    public static void setNumberOver(){
        System.out.print(NUMBER_OVER);
    }

    public static void setAmountTypeError(){
        System.out.print(AMOUNT_TYPE_ERROR);
    }

    public static void setAmountNumber(){
        System.out.print(AMOUNT_NUMBER);
    }
}
