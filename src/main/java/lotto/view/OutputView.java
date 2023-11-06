package lotto.view;

import lotto.model.LottoPlayerNumber;
import lotto.model.LottoPlayerNumbers;

public class OutputView {

    private enum OutputMessage {
        NUMBER_OF_LOTTO_TICKETS("%d개를 구매했습니다.\n");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }
    }

    public static void outputNumberOfLottoTicks(int numberOfLottoTickets) {
        System.out.printf(OutputMessage.NUMBER_OF_LOTTO_TICKETS.message, numberOfLottoTickets);
    }

    public static void outputLottoPlayerNumbers(LottoPlayerNumbers lottoPlayerNumbers) {
        System.out.println(OutputMessage.NUMBER_OF_LOTTO_TICKETS);
        lottoPlayerNumbers.getLottoPlayerNumbers()
                .stream()
                .map(LottoPlayerNumber::getLottoPlayerNumber)
                .forEach(System.out::println);
    }
}
