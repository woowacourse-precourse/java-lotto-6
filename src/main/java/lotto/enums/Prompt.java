package lotto.enums;

public enum Prompt {
    ASK_BUYING_PRICE("구입금액을 입력해 주세요."),
    ENTERED_BUYING_EA("개를 구매했습니다."),
    ASK_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    LINE("---");
    private final String prompt;

    Prompt(String prompt) {
        this.prompt = prompt;
    }


    public String getPrompt(){
        return this.prompt;
    }
}
