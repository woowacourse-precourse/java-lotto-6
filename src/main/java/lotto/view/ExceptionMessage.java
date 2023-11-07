package lotto.view;

public class ExceptionMessage {
    private static final String ERROR_LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호는 정확히 6개여야 합니다. 현재 입력된 번호 개수: ";
    private static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호의 범위가 1 ~ 45 사이의 수가 아닙니다.";
    private static final String ERROR_LOTTO_DUPLICATED = "[ERROR] 로또 번호가 중복되었습니다.";
    private static final String ERROR_NOT_LOTTO_NUMBER = "[ERROR] 로또 번호는 정수만 입력이 가능합니다.";
    private static final String ERROR_DUPLICATED_LOTTO_AND_BONUS = "[ERROR] 로또 번호와 보너스 번호가 중복되었습니다. 다시 입력해 주시시오";
    private static final String ERROR_AMOUNT_NOT_DIVIDE = "[ERROR] 입력하신 금액이 1000원으로 나누어 떨어지지 않습니다. 다시 입력해 주십시오";


    public static String sizeException() {
        return ERROR_LOTTO_NUMBER_SIZE;
    }

    public static String rangeException() {
        return ERROR_LOTTO_NUMBER_RANGE;
    }

    public static String duplicatedException() {
        return ERROR_LOTTO_DUPLICATED;
    }

    public static String notNumberException() {
        return ERROR_NOT_LOTTO_NUMBER;
    }

    public static String amountDivideException() {
        return ERROR_AMOUNT_NOT_DIVIDE;
    }

    public static String lottoNumberAndBonusDuplicatedException() {
        return ERROR_DUPLICATED_LOTTO_AND_BONUS;
    }
}
