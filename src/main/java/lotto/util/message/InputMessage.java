package lotto.util.message;

public class InputMessage extends Message {

    public static void requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
