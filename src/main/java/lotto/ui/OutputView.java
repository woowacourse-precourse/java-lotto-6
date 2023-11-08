package lotto.ui;

import static lotto.enums.PrintMessage.RESPONSE_LOTTO_COUNT;
import static lotto.enums.PrintMessage.RESPONSE_WINNING_STATISTICS;
import static lotto.enums.PrintMessage.RESPONSE_WINNING_STATISTICS_FORMAT;
import static lotto.enums.PrintMessage.RESPONSE_WINNING_STATISTICS_FORMAT_WITH_BONUS;
import static lotto.enums.PrintMessage.RESPONSE_YIELD;

import java.util.Arrays;
import lotto.domain.LottoTicket;
import lotto.dto.WinningResult;
import lotto.enums.Prize;
import lotto.util.Converter;

public class OutputView {
    public void printError(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoTicket(final LottoTicket lottoTicket) {
        System.out.printf(RESPONSE_LOTTO_COUNT.getMassage(), lottoTicket.count());
        lottoTicket.lottoTicket().forEach(System.out::println);
        System.out.println();
    }

    public void printWinningResult(final WinningResult winningResult) {
        System.out.println(RESPONSE_WINNING_STATISTICS.getMassage());
        Arrays.stream(Prize.PRIZES)
                .filter(prize -> prize != Prize.NONE)
                .forEach(prize -> System.out.println(createResultMessage(winningResult.countOf(prize), prize)));
    }

    private String createResultMessage(final int countOfPrize, final Prize prize) {
        final int matchedCount = prize.getMatchedCount();
        final String winningAmount = Converter.convertNumberWithComma(prize.getWinningAmount());
        final String format = this.determineFormatByPrize(prize);
        return String.format(format, matchedCount, winningAmount, countOfPrize);
    }

    private String determineFormatByPrize(final Prize prize) {
        if (prize == Prize.SECOND) {
            return RESPONSE_WINNING_STATISTICS_FORMAT_WITH_BONUS.getMassage();
        }
        return RESPONSE_WINNING_STATISTICS_FORMAT.getMassage();
    }

    public void printYield(final String yield) {
        System.out.printf(RESPONSE_YIELD.getMassage(), yield);
    }
}
