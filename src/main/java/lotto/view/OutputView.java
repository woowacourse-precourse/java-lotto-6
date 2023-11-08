package lotto.view;


public class OutputView {
        public static void mentionInputPrice() {
                System.out.println("구입금액을 입력해 주세요.");
        }
        public void printLottoCount() {
                System.out.println("\n%개를 구매했습니다.");
        }
        public static void mentionInputWinningNumber() {
                System.out.println("\n당첨 번호를 입력해 주세요.");
        }
        public static void mentionInputBonusNumber() {
                System.out.println("\n보너스 번호를 입력해 주세요.");
        }
        public static void printWinmessage(String message,int winCount) {
                System.out.println(message + winCount + "개");
        }

}
