package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView INSTANCE = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String requestPurchaseAmount() {
        displayPurchaseAmount();
        return Console.readLine();
    }

    public String requestLottoWinningNumbers() {
        displayLottoWinningNumbers();
        return Console.readLine();
    }

    public String requestLottoBonusNumber() {
        displayLottoBonusNumber();
        return Console.readLine();
    }

    private void displayPurchaseAmount() {
        System.out.println(InputViewMessage.PURCHASE_AMOUNT.getInputViewMessage());
    }

    private void displayLottoWinningNumbers() {
        System.out.println(InputViewMessage.LOTTO_WINNING_NUMBERS.getInputViewMessage());
    }

    private void displayLottoBonusNumber() {
        System.out.println(InputViewMessage.LOTTO_BONUS_NUMBER.getInputViewMessage());
    }

    enum InputViewMessage {
        PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private String inputViewMessage;

        InputViewMessage(String inputViewMessage) {
            this.inputViewMessage = inputViewMessage;
        }

        private String getInputViewMessage() {
            return inputViewMessage;
        }
    }
}
