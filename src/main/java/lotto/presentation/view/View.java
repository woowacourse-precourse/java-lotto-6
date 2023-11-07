package lotto.presentation.view;

public class View {
    // 나중에 리터럴은 다 상수로 바꾸기
    public void promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void promptForError(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e);
    }
    public void printPurchaseSize(int purchaseSize) {
        System.out.println("\n" + purchaseSize + "개를 구매했습니다.");
    }
    public void printPurchaseLottoTicket(String lotto) {
        System.out.println(lotto);
    }
}
