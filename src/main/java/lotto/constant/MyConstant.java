package lotto.constant;

public class MyConstant {
    public static String MSG_SIZE_LOTTO_ENVELOP(Integer size) {
        return size + "개를 구매했습니다.";
    }

    public static String MSG_RATE_RESULT(Double rate) {
        return "총 수익률은 " + rate + "%입니다.";
    }

    public static String MSG_STATISTIC_FIFTH_PLACE_RESULT(Integer count) {
        return "3개 일치 (5,000원) - " + count + "개\n";
    }

    public static String MSG_STATISTIC_FOURTH_PLACE_RESULT(Integer count) {
        return "4개 일치 (50,000원) - " + count + "개\n";
    }

    public static String MSG_STATISTIC_THIRD_PLACE_RESULT(Integer count) {
        return "5개 일치 (1,500,000원) - " + count + "개\n";
    }

    public static String MSG_STATISTIC_SECOND_PLACE_RESULT(Integer count) {
        return "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개\n";
    }

    public static String MSG_STATISTIC_FIRST_PLACE_RESULT(Integer count) {
        return "6개 일치 (2,000,000,000원) - " + count + "개\n";
    }

    public static String MSG_INPUT_MONEY() {
        return "구입금액을 입력해 주세요.";
    }

    public static String MSG_INPUT_WIN_NUMBERS() {
        return "당첨 번호를 입력해 주세요.";
    }

    public static String MSG_INPUT_BONUS_NUMBER() {
        return "보너스 번호를 입력해 주세요.";
    }
}
