package lotto.view;


public class OutputView {
        public static void mentionInputPrice() {
                System.out.println("구입금액을 입력해 주세요.");
        }
        public static void printLottoCount(int count) {
                System.out.printf("\n%d개를 구매했습니다.\n",count);
        }
        public static void mentionInputWinningNumber() {
                System.out.println("\n당첨 번호를 입력해 주세요.");
        }
        public static void mentionInputBonusNumber() {
                System.out.println("\n보너스 번호를 입력해 주세요.");
        }
        public static void printResultMessage() {
                System.out.println("\n당첨 통계");
                System.out.println("---");
        }
        public static void printWinmessage(String message,int winCount) {
                System.out.println(message + winCount + "개");
        }

}
