package view;

public class OutputView {

    public void askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void informLottoCount(final int count) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.", count);
        System.out.println();
    }
}
