package lotto.view;

public enum Prompt {
    TOTAL_BUYING_AMOUNT("구입금액을 입력해 주세요."),
    ANSWER_OF_LOTTO("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_OF_LOTTO("보너스 번호를 입력해 주세요.");

    private final String prompt;
    Prompt(String prompt) {
        this.prompt = prompt;
    }

    public String getMessage() {
        return prompt;
    }
}
