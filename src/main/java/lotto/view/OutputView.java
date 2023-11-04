package lotto.view;

public class OutputView {

    public void printRequestInputPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printTicketQuantityMessage(Integer quantity) {
        System.out.println();
        String message = String.format("%s개를 구매했습니다.", quantity);
        System.out.println(message);
    }

    public void printRequestInputWinningNumberMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printRequestInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
