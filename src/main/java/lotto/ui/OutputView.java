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
                .forEach(p -> System.out.printf(getFormat(p),
                        p.getMatchedCount(), Converter.convertNumberWithComma(p.getWinningMoney()), winningResult.countOf(p)));
    } // TODO 수정

    private String getFormat(final Prize prize) {
        if (prize == Prize.SECOND) {
            return RESPONSE_WINNING_STATISTICS_FORMAT_WITH_BONUS.getMassage();
        }
        return RESPONSE_WINNING_STATISTICS_FORMAT.getMassage();
    } // TODO 수정

    public void printYield(final String yield) {
        System.out.printf(RESPONSE_YIELD.getMassage(), yield);
    }
}
