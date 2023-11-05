package lotto.output;

public class OutputManager {
    public static void print(Object outPutContents) {
        System.out.println(outPutContents);
    }

    public static void printLottoBuyMoneyInputGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printAnswerNumbersInputGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
