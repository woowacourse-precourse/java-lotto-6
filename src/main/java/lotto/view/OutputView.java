package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Player;

public class OutputView {

    private static final int AMOUNT_UNIT = 1_000;
    private static final String TICKET_BUY_RESULT_FORMAT = "개를 구매했습니다.";

    public static void printBuyingTicketQuantity(Player player){
        System.out.println();
        System.out.println(player.getPlayerTicketQuantity() + TICKET_BUY_RESULT_FORMAT);
    }

    public static void printPlayerLottoTicketInfo(Player player){
        player.getLottoTicket().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printException(Exception exception){
        System.out.println(exception.getMessage());
    }
}
