package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.common.constants.GuideMessage;
import lotto.common.constants.Symbol;
import lotto.common.utils.Utils;
import lotto.common.validate.Validate;

public class View {
    private final Validate validate;
    private final Utils utils;

    public View() {
        validate = new Validate();
        utils = new Utils();
    }

    public String inputConsole() {
        String input = Console.readLine();
        Validate.consoleBlank(input);
        return input;
    }

    public void buyPriceMessage() {
        System.out.println(GuideMessage.INPUT_BUY_PRICE.getMessage());
    }

    public void buyTicketCountMessage(int ticketCount) {
        System.out.println(ticketCount + GuideMessage.OUTPUT_BUY_LOTTO_COUNT.getMessage());
    }

    public void lottoTicketNumbers(ArrayList<ArrayList<Integer>> lottoTickets) {
        lottoTicketInformation(lottoTickets);
        System.out.println();
    }

    private void lottoTicketInformation(ArrayList<ArrayList<Integer>> lottoTickets) {
        for (ArrayList<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void sixHitLottoNumberMessage() {
        System.out.println(GuideMessage.INPUT_HIT_NUMBER.getMessage());
    }

    public void bonusHitNumberMessage() {
        System.out.println(GuideMessage.INPUT_BONUS_HIT_NUMBER.getMessage());
    }

    public void prizeStatsMessage() {
        System.out.println(GuideMessage.OUTPUT_PRIZE_STATS.getMessage());
        System.out.println(Symbol.DIVIDE_LINE.getSymbol());
    }
}
