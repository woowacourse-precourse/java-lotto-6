package lotto.utils;

public class Logs {
    private Logs() {

    }

    public static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void inputMoneyERROR() {
        System.out.println("[ERROR] 구입금액을 1,000원 단위 양수로 입력해 주세요.");
    }

    public static void inputWinningNumbersERROR() {
        System.out.println("[ERROR] 당첨 번호는 1부터 45사이의 중복되지 않는 6자리 숫자를 입력해 주세요.");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
