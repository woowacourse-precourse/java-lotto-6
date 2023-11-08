package lotto.Message;

public enum InputValidatorPrompt {
    ASK_NO_EMPTY_INPUT("[ERROR] 빈칸은 허용되지 않습니다. 올바르게 입력해주세요"),
    ASK_NO_WHITE_SPACE("[ERROR] 공백 없이 입력해주세요"),
    ASK_BUDGET_NUMBER_IN_RIGHT_FORMAT("[ERROR] 문자 혹은 특수기호는 입력할 수 없습니다. %d 이하의 숫자로 입력해주세요"),
    ASK_POSITIVE_NUMBER("[ERROR] 음수나 0이 아닌 금액을 입력해주세요"),
    ASK_MORE_THAN_MINIMUM("[ERROR] 1000원 이상의 금액을 입력해주세요 (1000의 배수로 입력해주세요)"),
    ASK_BUDGET_WITH_THOUSANDS_INCREMENT("[ERROR] 1000의 배수로 금액을 입력해주세요"),
    ASK_WINNING_NUM_IN_NUMBER("[ERROR] 문자 혹은 특수기호가 아닌 숫자로 입력해주세요"),
    ASK_WINNING_NUM_IN_VALID_RANGE("[ERROR] 1~45 사이의 숫자로 입력해주세요"),
    ASK_WINNING_NUM_IN_RIGHT_AMOUNT("[ERROR] 6개의 숫자를 쉼표로 구분하여 입력해주세요"),
    ASK_WINNING_NUM_WITH_NO_DUPLICATION("[ERROR] 중복된 숫자가 없게 입력해주세요"),
    ASK_BONUS_WINNING_NUM_NOT_DUPLICATE_WITH_WINNING_NUM("[ERROR] 먼저 입력한 당첨 번호와 중복되지 않게 입력해주세요");;



    private String message;

    InputValidatorPrompt(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
