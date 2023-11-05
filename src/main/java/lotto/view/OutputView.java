package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.model.LottoInfo;
import lotto.vo.TicketCount;

public class OutputView {

    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";
    private static final String FIFTH_RANK_MESSAGE = "3개 일치 (5,000원) - %s개";
    private static final String FOURTH_RANK_MESSAGE = "4개 일치 (50,000원) - %s개";
    private static final String THIRD_RANK_MESSAGE = "5개 일치 (1,500,000원) - %s개";
    private static final String SECOND_RANK_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %s개";
    private static final String FIRST_RANK_MESSAGE = "6개 일치 (2,000,000,000원) - %s개";
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String HYPHEN = "---";
    private static final String LINE = "\n";
    private static final Integer PERCENTAGE = 100;
    private static final Integer DEFAULT_COUNT = 0;

    public void printRequestInputBuyAmountMessage() {
        printMessage(INPUT_BUY_AMOUNT_MESSAGE);
    }

    public void printTicketCountMessage(final Integer count) {
        printMessage(String.format(TICKET_COUNT_MESSAGE, count));
    }

    public void printRequestInputWinningNumberMessage() {
        printMessage(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public void printRequestInputBonusNumberMessage() {
        printMessage(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printPlayerNumbers(final List<LottoDto> playerLotteries) {
        playerLotteries.stream().forEach(lottoDto -> {
            printMessage(lottoDto.getNumbers().toString());
        });
        printMessage(LINE);
    }

    public void printStatistics(final Map<LottoRank, Integer> result) {
        printMessage(LINE + STATISTICS_MESSAGE);
        printMessage(HYPHEN);
        printMessage(String.format(FIFTH_RANK_MESSAGE, result.getOrDefault(LottoRank.FIFTH_RANK, DEFAULT_COUNT)));
        printMessage(String.format(FOURTH_RANK_MESSAGE, result.getOrDefault(LottoRank.FOURTH_RANK, DEFAULT_COUNT)));
        printMessage(String.format(THIRD_RANK_MESSAGE, result.getOrDefault(LottoRank.THIRD_RANK, DEFAULT_COUNT)));
        printMessage(String.format(SECOND_RANK_MESSAGE, result.getOrDefault(LottoRank.SECOND_RANK, DEFAULT_COUNT)));
        printMessage(String.format(FIRST_RANK_MESSAGE, result.getOrDefault(LottoRank.FIRST_RANK, DEFAULT_COUNT)));
    }

    public void printRateOfProfit(final Map<LottoRank, Integer> result, TicketCount ticketCount) {
        double reward = result.keySet()
                .stream()
                .mapToDouble(lottoRank -> (lottoRank.getPrizeMoney() * result.get(lottoRank)))
                .sum();

        double totalCost = (double) ticketCount.count() * LottoInfo.ONE_LOTTO_PRICE.getValue();
        double profitRate = (reward / totalCost) * PERCENTAGE;

        printMessage(String.format(PROFIT_RATE_MESSAGE, profitRate));
    }

    public void printMessage(final String message) {
        System.out.println(message);
    }
}
