package lotto.utils;

public class Writer {
    private final static String PROMPT_MONEY, PROMPT_WINNING_NUMBERS, PROMPT_BONUS_NUMBER,
            INVALID_MONEY_ERROR, INVALID_WINNING_NUMBERS_ERROR, INVALID_BONUS_NUMBER_ERROR;

    static {
        PROMPT_MONEY = "구입금액을 입력해 주세요.";
        PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

        INVALID_MONEY_ERROR = "[ERROR] 구입금액은 1,000원 단위 양수입니다.";
        INVALID_WINNING_NUMBERS_ERROR = "[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6자리 숫자입니다.";
        INVALID_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.";
    }

    private Writer() {

    }

    public static void promptMoney() {
        System.out.println(PROMPT_MONEY);
    }

    public static void promptWinningNumbers() {
        System.out.println(PROMPT_WINNING_NUMBERS);
    }

    public static void promptBonusNumber() {
        System.out.println(PROMPT_BONUS_NUMBER);
    }

    public static void invalidMoneyError() {
        System.out.println(INVALID_MONEY_ERROR);
    }

    public static void invalidWinningNumbersError() {
        System.out.println(INVALID_WINNING_NUMBERS_ERROR);
    }

    public static void invalidBonusNumberError() {
        System.out.println(INVALID_BONUS_NUMBER_ERROR);
    }

    public static void newLine() {
        System.out.println();
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
