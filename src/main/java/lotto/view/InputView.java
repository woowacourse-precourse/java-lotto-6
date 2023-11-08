package lotto.view;

public class InputView {
    private static final String inputAmountMention = "구입금액을 입력해 주세요.";
    private static final String inputWinningNumberMention = "당첨 번호를 입력해 주세요.";
    private static final String inputWinningBonusNumberMention = "보너스 번호를 입력해 주세요.";

    public void inputAmountView() {
        System.out.println(inputAmountMention);
    }

    public void inputWinningNumberView() {
        System.out.println(inputWinningNumberMention);
    }

    public void inputWinningBonusNumberView() {
        System.out.println(inputWinningBonusNumberMention);
    }
}
