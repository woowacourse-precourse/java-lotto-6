package lotto.util;

import lotto.view.InputView;

public class Message {
    public enum ErrorMessage{
        BUDGET_EXCEPTION("[ERROR] 1000원 단위 정수로 입력해 주세요."),
        WINNING_NUMBER_EXCEPTION("[ERROR] 콤마(,)로 구분하여 1~45 사이의 수를 중복 없이 6개 입력해 주세요."),
        BONUS_NUMBER_EXCEPTION("[ERROR] 기존 당첨 번호와 중복됩니다."),
        NUMBER_FORMAT_EXCEPTION("[ERROR] 1~45 사이 정수를 입력해 주세요.");
        final String message;
        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum InputMessage {
        INPUT_BUDGET("구입 금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
        final String message;
        InputMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
