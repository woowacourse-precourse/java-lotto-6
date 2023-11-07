package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private enum InputMessage {
        AMOUNT("구입금액을 입력해 주세요."),
        WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        private InputMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    public String inputAmount() {
        System.out.println(InputMessage.AMOUNT);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER);
        return Console.readLine();
    }
}
