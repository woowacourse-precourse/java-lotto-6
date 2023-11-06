package lotto;

public class Messages {
    public enum ErrorMessage{
        NONNUMERICCHAR("[ERROR] 숫자가 아닌 문자가 입력되었습니다."),
        NULLSTRING("[ERROR] 비어있는 문자열이 입력되었습니다."),
        NOTDIVIED1000("[ERROR] 1000으로 나누어 떨어지지 않습니다.");

        private String errorMessage;
        private ErrorMessage(String message){
            this.errorMessage = message;
        }
        public String getMessage(){
            return this.errorMessage;
        }
    }

    public enum MainMessage{
        INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
        WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요."),
        WINNING_STATISTICS("당첨 통계\n---"),
        NUMBER_OF_ITEMS_PURCHASE("%d개를 구매했습니다.");

        private String mainMessage;
        private MainMessage(String message){
            this.mainMessage = message;
        }
        public String getMessage(){
            return this.mainMessage;
        }
    }

    public enum WinningStatistics{
        WIN_3_MATCH("3개 일치 (5,000원) - %d개"),
        WIN_4_MATCH("4개 일치 (50,000원) - %d개"),
        WIN_5_MATCH("5개 일치 (1,500,000원) - %d개"),
        WIN_5_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
        WIN_6_MATCH("6개 일치 (2,000,000,000원) - %d개");

        private String winningStatisticsMessage;
        private WinningStatistics(String message){
            this.winningStatisticsMessage = message;
        }
        public String getMessage(){
            return this.winningStatisticsMessage;
        }
    }
}
