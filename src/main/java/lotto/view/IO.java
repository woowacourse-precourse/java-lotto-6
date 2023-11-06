package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constants.Front;

public class IO {
    public static void requestPerchaseAmount(Front message) {
        System.out.println(message.getMessage());
    }

    public static void checkLottoTickets(final int lottoTicketCount, Front message){
        System.out.println(lottoTicketCount+message.getMessage());
    }
}
