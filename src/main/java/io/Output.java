package io;

import java.util.List;

public class Output {

    enum Prize {
        MATCH_3("3개 일치 (5,000원) - "),
        MATCH_4("4개 일치 (50,000원) - "),
        MATCH_5("5개 일치 (1,500,000원) - "),
        MATCH_5_WITH_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        MATCH_6("6개 일치 (2,000,000,000원) - ");

        private final String message;

        Prize(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static String errorCanNotDivideMessage = "[ERROR] 1000으로 나누어 떨어지는 수를 입력해주세요";
    public static String errorOver6NumbersMessage = "[ERROR] 로또번호가 6개 초과입니다.";
    public static String errorSameNumberInInputMessage = "[ERROR] 중복된 숫자가 입력되었습니다.";
    public static String errorNeedIntInputMessage = "[ERROR] 입력값에 숫자가 아닌 문자가 포함되어 있습니다.";

    public static String errorValidIntegerNumber = "[ERROR] 유효한 양의 정수를 입력해야 합니다.";
    public static String errorValidSpecialNumber = "[ERROR] 1~45사이의 정수 한개만 입력해주세요.";
    public static String errorNumberIsOver0 = "[ERROR] 입력값은 0보다 커야 합니다.";

    public String introduceGameMessage() {
        return "구입금액을 입력해 주세요.";
    }

    public static String buyLottoMessage(int size) {
        printMessage("");
        return size + "개를 구매했습니다.";
    }

    public String insertLottoNumberMessage() {
        printMessage("");
        return "당첨 번호를 입력해 주세요.";
    }

    public String insertBonusLottoNumberMessage() {
        printMessage("");
        return "보너스 번호를 입력해 주세요.";
    }


    public String hitAverageMessage() {
        printMessage("");
        return "당첨 통계";
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void totalProfitMessage(String message) {
        printMessage("총 수익률은 " + message + "%입니다.");
    }

    public static void resultLottoMessage(List<Integer> hitLottos) {
        printMessage("---");
        for (Prize prize : Prize.values()) {
            int index = prize.ordinal();
            printMessage(prize.getMessage() + hitLottos.get(index) + "개");
        }
    }
}
