package lotto.view.output;

public enum PrintMessage {

    ASKING_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ASKING_COST("구입 금액을 입력해 주세요."),
    ASKING_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    PRINT_AMOUNT("%d개를 구매했습니다."),
    PRINT_STATISTICS("당첨 통계\n---\n%s\n%s\n%s\n%s\n%s\n%s"),
    PRINT_FIFTH_RANK("%d개 일치 (%d) - %d개"),
    PRINT_FOURTH_RANK("%d개 일치 (%d) - %d개"),
    PRINT_THIRD_RANK("%d개 일치 (%d) - %d개"),
    PRINT_SECOND_RANK("%d개 일치, 보너스 볼 일치 (%d) - %d개"),
    PRINT_FIRST_RANK("%d개 일치 (%d) - %d개"),
    PRINT_RATE_OF_RETURN("총 수익률은 %.2f%%입니다.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
