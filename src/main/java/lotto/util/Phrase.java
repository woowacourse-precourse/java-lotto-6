package lotto.util;
import java.util.Arrays;

public class Phrase {
    public enum InputPhrase {
        INPUT_COST("구입금액을 입력해 주세요."),
        INPUT_ORIGINALNUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS("보너스 번호를 입력해 주세요.");
        private final String message;

        InputPhrase(String message) {
            this.message = message;
        }
        public String printMessage(){
            return message;
        }
    }

    public enum OutputPhrase {
        BUY_HOWMUCH("%d개를 구매했습니다.\n");
        private final String message;

        OutputPhrase(String message) {
            this.message = message;
        }
        public String printMessage(){
            return message;
        }
    }

    public enum DrawPhrase {
        DRAW_STATISTIC("당첨 통계\n---"),
        THREE_MATCHES("3개 일치 (5,000원) - %d개\n"),
        FOUR_MATCHES("4개 일치 (50,000원) - %d개\n"),
        FIVE_MATCHES("5개 일치 (1,500,000원) - %d개\n"),
        FIVE_AND_BONUS_MATCHES("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
        SIX_MATCHES("6개 일치 (2,000,000,000원) - %d개\n");

        private final String message;

        DrawPhrase(String message) {
            this.message = message;
        }
        public String printMessage(){
            return message;
        }

    }
    public enum RevenuePhrase {
        TOTAL_REVENUE_RATE("총 수익률은 %.1f%%입니다.\n");
        private final String message;
        RevenuePhrase(String message) {
            this.message = message;
        }
        public String printMessage(){
            return message;
        }
    }

}
