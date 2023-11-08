package lotto.io.output;

import java.util.Map;
import lotto.constant.LottoConstant;
import lotto.constant.LottoResultRule;
import lotto.constant.message.LottoResultMessage;
import lotto.constant.message.ProcessMessage;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;
import lotto.domain.WinningStatistic;

public class OutputFommatter {


    public String toNumberOfTicket(final Ticket ticket) {
        return String.format(ProcessMessage.NUMBER_OF_LOTTO_TICKET.toMessage(), ticket.toValue());
    }

    public String toLottos(final Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos.toElements()) {
            appendLottoNumbers(stringBuilder, lotto);
        }
        return stringBuilder.toString();
    }

    private void appendLottoNumbers(StringBuilder stringBuilder, Lotto lotto) {
        stringBuilder.append(ProcessMessage.LEFT_SQUARE_BRACKET.toMessage());
        for (Integer number : lotto.getNumbers()) {
            stringBuilder.append(number).append(ProcessMessage.COMMA.toMessage());
        }
        stringBuilder.delete(stringBuilder.length() - LottoConstant.UNNECESSARY_INDEX, stringBuilder.length());
        stringBuilder.append(ProcessMessage.RIGHT_SQUARE_BRACKET.toMessage())
                .append(ProcessMessage.NEW_LINE.toMessage());
    }

    public String toLottoResult(final WinningStatistic winningStatistic) {
        final StringBuilder stringBuilder = new StringBuilder();
        Map<LottoResultRule, Integer> enumMap = winningStatistic.toElements();

        appendResultMessage(stringBuilder, LottoResultMessage.THREE_MATCH, LottoResultRule.THREE_MATCH, enumMap);
        appendResultMessage(stringBuilder, LottoResultMessage.FOUR_MATCH, LottoResultRule.FOUR_MATCH, enumMap);
        appendResultMessage(stringBuilder, LottoResultMessage.FIVE_MATCH, LottoResultRule.FIVE_MATCH, enumMap);
        appendResultMessage(stringBuilder, LottoResultMessage.FIVE_MATCH_WITH_BONUS, LottoResultRule.FIVE_MATCH_WITH_BONUS, enumMap);
        appendResultMessage(stringBuilder, LottoResultMessage.SIX_MATCH, LottoResultRule.SIX_MATCH, enumMap);

        return stringBuilder.toString();
    }

    private void appendResultMessage(StringBuilder stringBuilder, LottoResultMessage message, LottoResultRule rule, Map<LottoResultRule, Integer> enumMap) {
        stringBuilder.append(String.format(message.toMessage(),
                        enumMap.getOrDefault(rule, LottoConstant.ZERO).toString()))
                .append(ProcessMessage.NEW_LINE.toMessage());
    }


    public String toLottoProfit(final String profit) {
        return String.format(LottoResultMessage.PROFIT.toMessage(), Double.valueOf(profit));
    }
}
