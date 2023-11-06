package lotto.view;

public class ErrorMessage {
    public static String NOT_NUM_ERROR = "양수가 아닙니다.";
    public static String NOT_ZERRO = "0을 입력할 수 없습니다.";
    public static String NOT_TICKET_COUNT = "1000원으로 나눌 수 없습니다.";
    public static String NOT_VALID_LENGTH = "로또 번호가 6개가 아닙니다.";
    public static String NOT_VALID_NUMBER = "1~45 사이의 수가 아닙니다.";
    public static String EXIST_DUPLICATE_NUMBER = "중복된 숫자가 있습니다.";

    public static void printErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
