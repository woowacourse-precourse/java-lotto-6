package lotto.util;

public class ControllerOutputManager {
    private final String START_PRINT = "구입금액을 입력해 주세요.";
    private final String BUY_PRINT = "개를 구매했습니다.";
    private final String WINNING_PRINT = "당첨 번호를 입력해 주세요.";
    private final String BONUS_PRINT = "보너스 번호를 입력해 주세요.";

    public void START_PRINT() {
        System.out.println(START_PRINT);

    }

    public void BUY_PRINT(int count) {
        System.out.println(count + BUY_PRINT);
    }

    public void WINNING_PRINT() {
        System.out.println(WINNING_PRINT);
    }

    public void BONUS_PRINT() {
        System.out.println(BONUS_PRINT);
    }
}
