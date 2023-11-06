package lotto.view;

public class LottoInputView implements View {
    LottoInputView() {
    }

    public void requestMoney() {
        System.out.println("구입금액을 입력해 주세요.\n");
    }

    public void requestWinnerNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.\n");
    }

    public void requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.\n");
    }
}
