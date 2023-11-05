package lotto.console;

import static lotto.constant.LottoMessage.LINE_DIVIDER;
import static lotto.constant.LottoMessage.LOTTO_TICKETS_MESSAGE;
import static lotto.constant.LottoMessage.LOTTO_TICKETS_QUANTITY_MESSAGE;
import static lotto.constant.LottoMessage.TOTAL_RETURN_RATE_MESSAGE;
import static lotto.constant.LottoMessage.WINNING_STATISTICS_MESSAGE;
import static lotto.constant.LottoRuleConstant.LOSE_PRIZE_MONEY;

import java.util.List;
import java.util.Map;
import lotto.constant.LottoMessage;
import lotto.constant.Ranking;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoTicketsDto;
import lotto.model.Lotto;

public class ConsoleOutput {
    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public static void printLottoTickets(LottoTicketsDto lottoTicketsDto) {
        int quantity = lottoTicketsDto.quantity();
        List<Lotto> lottoTickets = lottoTicketsDto.lottoTickets();

        StringBuilder purchaseInfo = new StringBuilder();

        purchaseInfo.append(String.format(LOTTO_TICKETS_QUANTITY_MESSAGE, quantity));

        for (Lotto lottoTicket : lottoTickets) {
            purchaseInfo.append(String.format(LOTTO_TICKETS_MESSAGE, lottoTicket.toString()));
        }

        System.out.println(purchaseInfo);
    }

    public static void printLottoResult(LottoResultDto lottoResultDto) {
        Map<Ranking, Integer> lottoResult = lottoResultDto.getLottoResult();
        float returnRate = lottoResultDto.getReturnRate();

        StringBuilder winningResult = new StringBuilder();

        winningResult.append(WINNING_STATISTICS_MESSAGE)
                .append(LINE_DIVIDER)
                .append(makeLottoResultMessage(lottoResult))
                .append(String.format(TOTAL_RETURN_RATE_MESSAGE, returnRate));

        System.out.println(winningResult);
    }

    private static StringBuilder makeLottoResultMessage(Map<Ranking, Integer> lottoResult) {
        StringBuilder lottoResultMessage = new StringBuilder();

        for (Ranking ranking : lottoResult.keySet()) {
            String message = ranking.getMessage();
            int prizeMoney = ranking.getPrizeMoney();

            int count = lottoResult.get(ranking);

            if (prizeMoney != LOSE_PRIZE_MONEY) {
                lottoResultMessage.append(String.format(LottoMessage.LOTTO_RESULT_MESSAGE, message, prizeMoney, count));
            }
        }

        return lottoResultMessage;
    }

    public static void printNewLine() {
        System.out.println();
    }
}
