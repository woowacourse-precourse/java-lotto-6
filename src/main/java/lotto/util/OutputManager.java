package lotto.util;

public class OutputManager {
    public static final String WRONG_NUMBER = "[ERROR] 잘못된 입력입니다.";
    private static final String START_PRINT = "구입금액을 입력해 주세요.";
    private static final String BUY_PRINT = "개를 구매했습니다.";
    private static final String WINNING_PRINT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_PRINT = "보너스 번호를 입력해 주세요.";

    public static void START_PRINT() {
        System.out.println(START_PRINT);
    }

    public static void BUY_PRINT(Long count) {
        System.out.println(count + BUY_PRINT);
    }

    public static void WINNING_PRINT() {
        System.out.println(WINNING_PRINT);
    }

    public static void BONUS_PRINT() {
        System.out.println(BONUS_PRINT);
    }

    public static void PRINT_WRONG() {
        System.out.println(WRONG_NUMBER);
    }
}
