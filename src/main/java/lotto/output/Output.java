package lotto.output;

public class Output {

    public static void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusLottoNumbersInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
