package lotto.view;

public class OutputView {
    public void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printCountPurchaseLottoMessage(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printInputErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
