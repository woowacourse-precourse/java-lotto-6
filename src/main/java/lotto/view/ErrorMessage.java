package lotto.view;

public class ErrorMessage {
    public static String NOT_NUM_ERROR = "양수가 아닙니다.";

    public static void printErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
