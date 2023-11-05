package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static String NUMBER_OF_LOTTO_TICKETS = "\n%d개를 구매했습니다.";
    private static final String LIST_FORMAT = "[%s]";

    public static void printLottoTickets(List<Lotto> lottoNumbers){
        for (Lotto lotto : lottoNumbers) {
            System.out.println(String.format(LIST_FORMAT, lotto.toString()));
        }
    }

    public static void printNumberOfLottoTickets(int count){
        System.out.println(String.format(NUMBER_OF_LOTTO_TICKETS, count));
    }

    public static void printErrorMessage(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
