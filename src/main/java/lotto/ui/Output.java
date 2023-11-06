package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    static final String NEW_LINE = "\n";
    static final String INFORM_GET_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    static final String INFORM_BUY_LOTTO_COUNT = "%d개를 구매했습니다.";
    static final String INFORM_GET_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String INFORM_WINNING_STATISTICS = "당첨 통계";
    static final String INFORM_PROFIT_RATE = "총 수익률은 %.1f%%입니다.";
    static final String DIVIDE_LINE = "---";

    public static final String ERROR = "[ERROR]";
    public static final String MUST_BE_NUMBERS_BETWEEN_1_45_ERROR = ERROR + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String MUST_BE_BONUS_NUMBER_BETWEEN_1_45_ERROR = ERROR + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String HAS_DUPLICATE_NUMBER_ERROR = ERROR + "중복된 로또 번호 입니다.";
    public static final String MUST_BE_SIX_NUMBER_ERROR = ERROR + "로또 번호는 6자리여야 합니다.";
    public static final String MUST_INPUT_MONEY_UNITS_OF_1000_WON_ERROR = ERROR + "1000원 단위로 입력해주세요.";
    public void notifyPayment() {
        System.out.println(INFORM_GET_PURCHASE_AMOUNT);
    }
    public void notifyLottoCount(int count) {
        System.out.printf(INFORM_BUY_LOTTO_COUNT + NEW_LINE, count);
    }

    public void notifyLottoNumbers(List<Integer> lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void notifyWinningNumbers() {
        System.out.println(INFORM_GET_WINNING_NUMBER);
    }

    public void notifyWinningDetails(List<Integer> result) {
        System.out.println(INFORM_WINNING_STATISTICS);
        System.out.println(DIVIDE_LINE);
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(0));
    }

    public void notifyProfitRate(float rate) {
        System.out.printf(INFORM_PROFIT_RATE, rate);
    }
}
