package lotto.view;

public class ExceptionMessage {

    private static final String AMOUNT_SIZE_ERROR = "[ERROR] 입력 금액은 1,000원 이상이어야 합니다.";
    private static final String AMOUNT_STYLE_ERROR = "[ERROR] 입력 금액은 1,000원 단위여야 합니다.";
    private static String INPUT_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복되는 값을 사용할 수 없습니다.";
    private static String INPUT_RANGE_ERROR="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static String INPUT_SIZE_ERROR = "[ERROR] 당첨 번호는 6개의 숫자가 입력되어야 합니다.";

    public static void setAmountSizeError(){
        throw new IllegalArgumentException(AMOUNT_SIZE_ERROR);
    }

    public static void setAmountStyleError(){
        throw new IllegalArgumentException(AMOUNT_STYLE_ERROR);
    }

    public static void setInputDuplicateError(){
        throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR);
    }

    public static void setInputRangeError() {
        throw new IllegalArgumentException(INPUT_RANGE_ERROR);
    }

    public static void setInputSizeError(){
        throw new IllegalArgumentException(INPUT_SIZE_ERROR);
    }

}
