package lotto.view;

public enum InputView implements PrintView {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    InputView(String message) {
        this.message = message;
    }

    @Override
    public void printMessage() {
        System.out.println(message);
    }
}
