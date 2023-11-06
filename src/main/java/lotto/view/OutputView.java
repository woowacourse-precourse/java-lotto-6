package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoPrize;

public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s\n";
    private static final String TICKET_FORMAT = "%d개를 구매했습니다.\n";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PRIZE_COUNT_MESSAGE = "당첨 통계\n---\n";
    private static final String FIFTH_PRIZE_FORMAT = "3개 일치 (5,000원) - %d개\n";
    private static final String FORTH_PRIZE_FORMAT = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PRIZE_FORMAT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PRIZE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PRIZE_FORMAT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String MONEY_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public void println() {
        System.out.println();
    }

    public void printError(String errorMessage) {
        System.out.printf(ERROR_MESSAGE_FORMAT, errorMessage);
    }

    public void printMoneyInputMessage() {
        System.out.println(MONEY_INPUT_MESSAGE);
    }

    public void printTicket(long ticket) {
        System.out.printf(TICKET_FORMAT, ticket);
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printWinningLottoInputMessage() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printPrizeCount(Map<LottoPrize, Integer> result) {
        System.out.printf(PRIZE_COUNT_MESSAGE);
        System.out.printf(FIFTH_PRIZE_FORMAT, result.get(LottoPrize.FIFTH_PLACE));
        System.out.printf(FORTH_PRIZE_FORMAT, result.get(LottoPrize.FORTH_PLACE));
        System.out.printf(THIRD_PRIZE_FORMAT, result.get(LottoPrize.THIRD_PLACE));
        System.out.printf(SECOND_PRIZE_FORMAT, result.get(LottoPrize.SECOND_PLACE));
        System.out.printf(FIRST_PRIZE_FORMAT, result.get(LottoPrize.FIRST_PLACE));
    }

    public void printMoneyRate(double rate) {
        System.out.printf(MONEY_RATE_FORMAT, rate);
    }
}
