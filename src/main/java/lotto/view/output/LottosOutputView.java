package lotto.view.output;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottosOutputView {
    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";

    public void printLottos(int numberOfLottoTickets, Lottos lottos) {
        printNumberOfLottoTickets(numberOfLottoTickets);
        printLottoNumbers(lottos);
        System.out.println();
    }

    private void printNumberOfLottoTickets(int numberOfLottoTickets) {
        System.out.println(String.format(PURCHASE_MESSAGE, numberOfLottoTickets));
    }

    private void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
