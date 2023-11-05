package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.constants.GuideMessage;
import lotto.validate.Validate;

public class View {
    private final Validate validate;

    public View() {
        validate = new Validate();
    }

    public int buyPriceMessage() {
        System.out.println(GuideMessage.INPUT_BUY_PRICE_MESSAGE.getMessage());
        return inputBuyPrice();
    }

    public void buyTicketCountMessage(int ticketCount) {
        System.out.println(ticketCount + GuideMessage.OUTPUT_BUY_LOTTO_COUNT_MESSAGE.getMessage());
    }

    public void lottoTicketInformation(ArrayList<ArrayList<Integer>> lottoTickets) {
        for (int i = 0; i < lottoTickets.size(); i++) {
            System.out.println(lottoTickets.get(i));
        }
    }

    private int inputBuyPrice() {
        String inputPrice = Console.readLine();
        try {
            validate.buyPriceValidate(inputPrice);
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            return inputBuyPrice();
        }
    }
}
