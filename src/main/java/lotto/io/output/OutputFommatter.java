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
        final StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos.toElements()) {
            stringBuilder.append(ProcessMessage.LEFT_SQUARE_BRACKET.toMessage());
            for (Integer number : lotto.getNumbers()) {
                stringBuilder.append(number).append(ProcessMessage.COMMA.toMessage());
            }
            stringBuilder.delete(stringBuilder.length() - LottoConstant.UNNECESSARY_INDEX, stringBuilder.length());
            stringBuilder.append(ProcessMessage.RIGHT_SQUARE_BRACKET.toMessage())
                    .append(ProcessMessage.NEW_LINE.toMessage());
        }
        return stringBuilder.toString();
    }

    public String toLottoResult(final WinningStatistic winningStatistic) {
        final StringBuilder stringbuilder = new StringBuilder();
        Map<LottoResultRule, Integer> enumMap = winningStatistic.toElements();
        stringbuilder.append(String.format(LottoResultMessage.THREE_MATCH.toMessage(),
                        enumMap.getOrDefault(LottoResultRule.THREE_MATCH, LottoConstant.ZERO).toString()))
                .append(ProcessMessage.NEW_LINE.toMessage());
        stringbuilder.append(String.format(LottoResultMessage.FOUR_MATCH.toMessage(),
                        enumMap.getOrDefault(LottoResultRule.FOUR_MATCH, LottoConstant.ZERO).toString()))
                .append(ProcessMessage.NEW_LINE.toMessage());
        stringbuilder.append(String.format(LottoResultMessage.FIVE_MATCH.toMessage(),
                        enumMap.getOrDefault(LottoResultRule.FIVE_MATCH, LottoConstant.ZERO).toString()))
                .append(ProcessMessage.NEW_LINE.toMessage());
        stringbuilder.append(String.format(LottoResultMessage.FIVE_MATCH_WITH_BONUS.toMessage(),
                        enumMap.getOrDefault(LottoResultRule.FIVE_MATCH_WITH_BONUS, LottoConstant.ZERO).toString()))
                .append(ProcessMessage.NEW_LINE.toMessage());
        stringbuilder.append(String.format(LottoResultMessage.SIX_MATCH.toMessage(),
                enumMap.getOrDefault(LottoResultRule.SIX_MATCH, LottoConstant.ZERO).toString()));
        return stringbuilder.toString();
    }

//    public String toLottoResult(final WinningStatistic winningStatistic) {
//        EnumMap<LottoResultRule, Integer> enumMap = winningStatistic.toElements();
//
//        return Arrays.stream(LottoResultRule.values())
//                .map(rule -> String.format(LottoResultMessage.getEnum(LottoResultRule.getEnum(rule.toString())),
//                        enumMap.getOrDefault(rule, 0).toString()) + ProcessMessage.NEW_LINE.toMessage())
//                .collect(Collectors.joining());
//    }

    public String toLottoProfit(final String profit) {
        return String.format(LottoResultMessage.PROFIT.toMessage(), Double.valueOf(profit));
    }
}
