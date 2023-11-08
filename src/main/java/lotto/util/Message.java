package lotto.util;

public class Message {
    public enum ErrorMessage {
        BUDGET_EXCEPTION("[ERROR] 1000원 단위 정수로 입력해 주세요."),
        WINNING_NUMBER_EXCEPTION("[ERROR] 콤마(,)로 구분하여 1~45 사이의 수를 중복 없이 6개 입력해 주세요."),
        DUPLICATION_EXCEPTION("[ERROR] 기존 당첨 번호가 중복됩니다."),
        NOT_INTEGER_EXCEPTION("[ERROR] 양의 정수를 입력해 주세요."),
        LOTTO_NUMBER_EXCEPTION("[ERROR] 1~45 사이 정수를 입력해 주세요.");
        private final String message;

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

    public enum LottoMessage {
        FIRST("1등", "6개 일치 (2,000,000,000원) - %d개\n", 2000000000, 6),
        SECOND("2등", "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30000000, 5),
        THIRD("3등", "5개 일치 (1,500,000원) - %d개\n", 1500000, 5),
        FOURTH("4등", "4개 일치 (50,000원) - %d개\n", 50000, 4),
        FIFTH("5등", "3개 일치 (5,000원) - %d개\n", 5000, 3);

        private final String rank;
        private final String message;
        private final int prize;
        private final int count;

        LottoMessage(String rank, String message, int prize, int count) {
            this.rank = rank;
            this.message = message;
            this.prize = prize;
            this.count = count;
        }

        public String getRank() {
            return rank;
        }

        public void printMessage(int count) {
            System.out.printf(message, count);
        }

        public int getCurrentPrize(String result) {
            if (rank.equals(result)) {
                return prize;
            }
            return 0;
        }

        public int getCount() {
            return count;
        }

    }
}
