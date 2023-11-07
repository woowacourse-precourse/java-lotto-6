package lotto.view;

public class OutputView {
    public static final String askMoneyMessage = "구입금액을 입력해 주세요.";
    public static final String askWinningNumbersMessage = "당첨 번호를 입력해 주세요.";
    public static final String askBonusNumberMessage = "보너스 번호를 입력해 주세요.";
    public static final String noticeTrialMessage = "개를 구매했습니다.";

    public static void printAskMoneyMessage() {
        System.out.println(askMoneyMessage);
    }

    public static void printNoticeTrialMessage(int trial) {
        System.out.println(trial + noticeTrialMessage);
    }

    public static void printAskWinningNumbersMessage() {
        System.out.println(askWinningNumbersMessage);
    }

    public static void printAskBonusNumberMessage() {
        System.out.println(askBonusNumberMessage);
    }
}
