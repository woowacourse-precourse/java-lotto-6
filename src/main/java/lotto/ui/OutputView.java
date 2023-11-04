package lotto.ui;

public class OutputView {
    public void printInvalidateMoneyStatement() {
        System.out.println("[ERROR] 1,000원 단위로 입력돼야 합니다.");
    }

    public void enterYourAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }
}
