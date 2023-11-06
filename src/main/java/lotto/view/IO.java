package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.constants.Front;

public class IO {
    public static void requestPerchaseAmount(Front message) {
        System.out.println(message.getMessage());
    }

    public static void checkLottoTickets(final int lottoTicketCount, Front message){
        System.out.println(lottoTicketCount+message.getMessage());
    }

    public static void viewLottoTickets(final List<Lotto>lottoTickets){
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }
}
