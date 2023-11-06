package lotto.view;

import lotto.model.Constant;

public class Message {
    /* Messages for UserInput */
    public static final String INPUT_BOUGHT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    /* Messages for UserOutput */
    public static final String OUTPUT_BOUGHT_NUMBER = "개를 구매했습니다.";
    public static final String OUTPUT_STATICS_INFO = "당첨 통계\n---";
    public static final String OUTPUT_STATICS_FIRST = String.format("6개 일치 (%,d원) - ", Constant.FIRST_REWARD);
    public static final String OUTPUT_STATICS_SECOND = String.format("5개 일치, 보너스 볼 일치 (%,d원) - ", Constant.SECOND_REWARD);
    public static final String OUTPUT_STATICS_THIRD = String.format("5개 일치 (%,d원) - ", Constant.THIRD_REWARD);
    public static final String OUTPUT_STATICS_FOURTH = String.format("4개 일치 (%,d원) - ", Constant.FOURTH_REWARD);
    public static final String OUTPUT_STATICS_FIFTH = String.format("3개 일치 (%,d원) - ", Constant.FIFTH_REWARD);
    public static final String OUTPUT_STATICS_BACK = "개";
    public static final String OUTPUT_STATICS_RATE_FRONT = "총 수익률은";
    public static final String OUTPUT_STATICS_RATE_BACK = "%입니다.";

    /* Messages for UserError */
    public static final String ERROR_MONEY = String.format("[ERROR] %,d으로 나누어지는 수를 입력하세요.", Constant.LOTTO_PRICE);
    public static final String ERROR_WINNING_DUPLICATE = "[ERROR] 당첨 번호가 중복되었습니다.";
    public static final String ERROR_WINNING_COUNT = String.format("[ERROR] 당첨 번호는 %d개만 입력해야합니다.",Constant.LOTTO_SELECT_NUMBER);
    public static final String ERROR_WINNING_RANGE = String.format("[ERROR] 당첨 번호는 %d와 %d 사이의 숫자이어야 합니다.", Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER);
    public static final String ERROR_BONUS_DUPLICATE = "[ERROR] 보너스 번호가 당첨번호와 중복되었습니다.";
    public static final String ERROR_BONUS_RANGE = String.format("[ERROR] 보너스 번호는 %d와 %d 사이의 숫자이어야 합니다.", Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER);
}

