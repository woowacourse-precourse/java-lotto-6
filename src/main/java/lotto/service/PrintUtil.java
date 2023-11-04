package lotto.service;

public class PrintUtil {

    public void printPurchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumberOfLotto(int number) {
        System.out.println();
        System.out.println(number + "개를 구매했습니다.");
    }

    public void printWinnerNumbersInput() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public void printBonusNumberInput() {
        System.out.println();
        System.out.println("보너스 번호를 입력해주세요.");
    }
}
