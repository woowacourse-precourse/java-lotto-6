package lotto;

public class OutputConsole {

    public static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void print(Lottos lottos) {
        lottos.print();
    }

    public static void printResult(Lottos lottos, WinningLotto winningLotto) {
        lottos.printResult(winningLotto);
    }

}
