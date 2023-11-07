package util;

public class ControllerOutputManager {
    private final String START_PRINT = "구입금액을 입력해 주세요.";
    private final String BUY_PRINT = "개를 구매했습니다.";
    private final String WINNING_PRINT = "당첨 번호를 입력해 주세요.";
    private final String BONUS_PRINT = "보너스 번호를 입력해 주세요.";

    public String getSTART_PRINT() {
        return START_PRINT;
    }

    public String getBUY_PRINT() {
        return BUY_PRINT;
    }

    public String getWINNING_PRINT() {
        return WINNING_PRINT;
    }

    public String getBONUS_PRINT() {
        return BONUS_PRINT;
    }
}
