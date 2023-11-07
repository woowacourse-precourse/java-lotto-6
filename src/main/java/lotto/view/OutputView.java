package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottosPurchased;

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

    public void printNumberOfLottosPurchased(LottosPurchased lottosPurchased) {
        int numberOfLottos = lottosPurchased.getNumberOfLottos();

        System.out.print(numberOfLottos);
        System.out.println(PrintMessage.NUMBER_OF_LOTTOS);
    }

    public void printLottosPurchased(LottosPurchased lottosPurchased) {
        int numberOfLottos = lottosPurchased.getNumberOfLottos();

        for (int i = 0; i < numberOfLottos; i++) {
            System.out.println(lottosPurchased.getLotto(i));
        }
    }
}
