package lotto.view;

import lotto.LottoTicketsDto;
import lotto.ProfitRateDto;
import lotto.WinningRankCountsDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String NEW_LINE = "\n";
    private static final String TOTAL_TICKETS_MESSAGE = "개를 구매했습니다." + NEW_LINE;
    private static final String START_WINNING_COUNT_MESSAGE = "당첨통계" + NEW_LINE + "--" + NEW_LINE;
    private static final String WINNING_COUNTS_FORMAT = "%d개 일치%s (%,d원) - %d개" + NEW_LINE;
    private static final String BONUS_NUMBER_REQUIRED = ", 보너스 볼 일치";
    private static final String EMPTY = "";
    private static final String PROFIT_FORMAT_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void print(String message) {
        System.out.println(message);
    }

    public void printIssuedLottoTickets(final LottoTicketsDto lottoTicketsDto) {
        StringBuilder issued = new StringBuilder();
        appendTotalTickets(issued, lottoTicketsDto.getTotalTickets());
        appendLottoTickets(issued, lottoTicketsDto.getLottos());
        print(issued.toString());
    }

    public void printWinningCounts(final List<WinningRankCountsDto> winningRankCountsDtos) {
        StringBuilder line = new StringBuilder(START_WINNING_COUNT_MESSAGE);
        line.append(winningRankCountsDtos.stream()
                .map(winningRankCountsDto ->
                    String.format(WINNING_COUNTS_FORMAT,
                            winningRankCountsDto.getCountOfMatchingNumbers(),
                            getBonusMessage(winningRankCountsDto),
                            winningRankCountsDto.getPrize(),
                            winningRankCountsDto.getWinningCount()))
                .collect(Collectors.joining()));
        print(line.toString());
    }

    private String getBonusMessage(WinningRankCountsDto winningRankCountsDto) {
        String bonusMessage = EMPTY;
        if (winningRankCountsDto.isRequiresBonus()) {
            bonusMessage = BONUS_NUMBER_REQUIRED;
        }
        return bonusMessage;
    }

    public void printProfitRate(final ProfitRateDto profitRateDto) {
        print(String.format(PROFIT_FORMAT_FORMAT, profitRateDto.getProfitRate()));
    }

    private void appendTotalTickets(StringBuilder issued, Integer totalTickets) {
        issued.append(totalTickets)
                .append(TOTAL_TICKETS_MESSAGE);
    }

    private void appendLottoTickets(StringBuilder issued, List<List<Integer>> lottoTickets) {
        lottoTickets.stream()
                .map(ArrayList::new)
                .forEach(ticket -> {
            Collections.sort(ticket);
            issued.append(ticket);
            issued.append(NEW_LINE);
        });
    }

}
