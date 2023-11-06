package lotto.view;

public class LottoInputView implements View {
    LottoInputView() {
    }

    public void requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void requestWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}
