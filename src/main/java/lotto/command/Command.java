package lotto.command;

import lotto.command.validator.LottoValidator;
import lotto.command.validator.PurchaseAmountValidator;
import lotto.command.validator.Validator;

public enum Command {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.", new PurchaseAmountValidator()),
    BUY_LOTTO,
    OUTPUT_USER_LOTTO,
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.", new LottoValidator()),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_RESULT;

    private String message;
    private Validator validator;
    Command() {};
    Command(String message) {
        this.message = message;
    }
    Command(String message, Validator validator) {
        this.message = message;
        this.validator = validator;
    }

    public String getMessage() {
        return message;
    }

    public void validate(String input) {
        if(validator == null) return;

        validator.validate(input);
    }
}
