package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private enum PrintMessage {
        NUMBER_OF_LOTTOS("개를 구매했습니다."),
        WINNING_STATISTICS("당첨 통계\n---");

        private final String message;

        private PrintMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    private static final String NUMBER_OF_LOTTOS_PURCHASED_PRINT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_PRINT_MESSAGE = "당첨 통계\n---";

    public void printLottosPurchased(List<Lotto> lottosPurchased) {
        System.out.println();
        System.out.print(lottosPurchased.size());
        System.out.println(PrintMessage.NUMBER_OF_LOTTOS);

        for (Lotto lotto : lottosPurchased) {
            System.out.println(lotto);
        }
    }
}
