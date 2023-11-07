package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.TicketPurchaseAmount;

public class OutputView {
    private OutputView() {
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public static void printTicket(LottoTicket  lottoTickets) {
        List<Lotto> lottoNumbersList = lottoTickets.getLottoTickets();

        for (Lotto lottoNumbers : lottoNumbersList) {
            List<Integer> lottoNumberList = lottoNumbers.number();
            String sentence = joinList(convertNumberListToStringList(lottoNumberList));
            System.out.println(sentence);
        }
    }

    private static String joinList(List<String> list) {
        return "[" + String.join(", ", list) + "]";
    }

    private static List<String> convertNumberListToStringList(List<Integer> numberList) {
        return numberList.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
