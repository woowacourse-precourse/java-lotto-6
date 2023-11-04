package lotto.io;

import lotto.constant.ProcessMessage;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Ticket;

public class OutputFommatter {

    private static final int NUNECESSARY_INDEX = 2;

    public String toNumberOfTicket(final Ticket ticket) {
        return String.format(ProcessMessage.NUMBER_OF_LOTTO_TICKET.toValue(), ticket.toValue());
    }

    public String toLottos(final Lottos lottos) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (Lotto lotto : lottos.toElements()) {
            stringBuilder.append(ProcessMessage.LEFT_SQUARE_BRACKET.toValue());
            for (Integer number : lotto.getNumbers()) {
                stringBuilder.append(number).append(ProcessMessage.COMMA.toValue());
            }
            stringBuilder.delete(stringBuilder.length() - NUNECESSARY_INDEX, stringBuilder.length());
            stringBuilder.append(ProcessMessage.RIGHT_SQUARE_BRACKET.toValue() + ProcessMessage.NEW_LINE.toValue());
        }
        return stringBuilder.toString();
    }
}
