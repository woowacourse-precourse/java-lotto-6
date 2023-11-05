package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.common.constants.GuideMessage;
import lotto.common.utils.Utils;
import lotto.common.validate.Validate;

public class View {
    private final Validate validate;
    private final Utils util;

    public View() {
        validate = new Validate();
        util = new Utils();
    }

    public int buyPriceMessage() {
        System.out.println(GuideMessage.INPUT_BUY_PRICE.getMessage());
        return inputBuyPrice();
    }

    public void buyTicketCountMessage(int ticketCount) {
        System.out.println(ticketCount + GuideMessage.OUTPUT_BUY_LOTTO_COUNT.getMessage());
    }

    public void lottoTicketInformation(ArrayList<ArrayList<Integer>> lottoTickets) {
        for (ArrayList<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public List<Integer> sixHitLottoNumberMessage() {
        System.out.println(GuideMessage.INPUT_HIT_NUMBER.getMessage());
        return inputSixHitLottoNumber();
    }

    private String systemInput() {
        return Console.readLine();
    }

    private int inputBuyPrice() {
        String inputPrice = systemInput();
        try {
            validate.buyPriceValidate(inputPrice);
            return Integer.parseInt(inputPrice);
        } catch (IllegalArgumentException e) {
            return inputBuyPrice();
        }
    }

    private List<Integer> inputSixHitLottoNumber() {
        List<String> inputSixNumber = util.stringToStringList(systemInput());
        try {
            validate.sixHitLottoNumberValidate(inputSixNumber);
            return util.stringListToIntegerList(inputSixNumber);
        } catch (IllegalArgumentException e) {
            return inputSixHitLottoNumber();
        }
    }
}
