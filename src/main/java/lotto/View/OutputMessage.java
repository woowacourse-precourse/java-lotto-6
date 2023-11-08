package lotto.View;

public enum OutputMessage {

    Enter_Purchase_Mount("구입금액을 입력해 주세요."),
    Enter_Lotto_Numbers("당첨 번호를 입력해 주세요."),
    Enter_Bonus_Numbers("보너스 번호를 입력해 주세요."),
    PURCHASE_COUNT("\n%d개를 구매했습니다.\n"),
    TOTAL_PRIZE_TITLE("\n당첨 통계\n---"),
    TOTAL_EARN_RATE("총 수익률은 %.1f%%입니다."),
    TOTAL_PRIZE_COUNT("%d개 일치 (%,d원) - %d개%n"),
    TOTAL_BONUS_COUNT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n");
        final String message;

        OutputMessage(String message) {
            this.message = message;
        }

        public String getMessage(){
            return message;
        }
}
