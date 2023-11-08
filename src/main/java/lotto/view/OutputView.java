package lotto.view;

import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.LottoTickets;

public class OutputView {

    private static final String PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    private static final String ERROR_MESSAGE = "[ERROR]";

    public void printAutoLottoTickets(final LottoTickets lottoTickets) {
        printNewLine();
        printPurchasedLottoQuantity(lottoTickets);
        printLottoTicketInfo(lottoTickets);
        printNewLine();
    }

    private void printPurchasedLottoQuantity(final LottoTickets lottoTickets) {
        print(String.format(PURCHASED_MESSAGE, lottoTickets.size()));
    }

    private void printLottoTicketInfo(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            List<Integer> numbers = ascendingSort(lotto).toList();
            print(numbers.toString());
        }
    }

    private Stream<Integer> ascendingSort(Lotto lotto) {
        return lotto.getNumbers().stream().sorted();
    }

    public void printErrorMessage(final Exception e) {
        print(ERROR_MESSAGE + e.getMessage());
    }

    private void print(final String message) {
        System.out.println(message);
    }

    private void printNewLine() {
        System.out.println();
    }
}
