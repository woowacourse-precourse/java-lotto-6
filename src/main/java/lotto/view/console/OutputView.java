package lotto.view.console;

import lotto.dto.output.LottoIssueResultDTO;
import lotto.dto.output.ResultDTO;

public class OutputView {

    private static final String START_INPUT_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String START_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String START_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = "\n";
    private static final String TICKET_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String DRAW_STATISTICS_HEADER = "당첨 통계\n---\n";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %s%%입니다.\n";

    private OutputView() {
    }

    public static void printInputAmount() {
        System.out.println(START_INPUT_AMOUNT);
    }

    public static void printInputWinningNumbers() {
        System.out.println(START_INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonus() {
        System.out.println(START_INPUT_BONUS_NUMBER);
    }

    public static void printLottoIssueResult(LottoIssueResultDTO resultDTO) {
        System.out.printf(TICKET_PURCHASED_MESSAGE + NEW_LINE, resultDTO.getTicketCount());
        resultDTO.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printRankResult(ResultDTO resultDTO) {
        String rankResults = formatRankResults(resultDTO);
        System.out.println(rankResults);
    }

    private static String formatRankResults(ResultDTO resultDTO) {
        StringBuilder resultBuilder = new StringBuilder(DRAW_STATISTICS_HEADER);
        resultDTO.getResults().forEach(rankResultDTO ->
                resultBuilder.append(OutputFormatter.formatRankResult(rankResultDTO)).append(NEW_LINE)
        );
        return resultBuilder.toString();
    }

    public static void printProfitRate(double profitRate) {
        String formattedProfitRate = OutputFormatter.formatProfitRate(profitRate);
        System.out.printf(TOTAL_PROFIT_RATE_MESSAGE, formattedProfitRate);
    }
}
