package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottosOutputView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private final int numberOfLottoTickets;
    private final Lottos lottos;

    public LottosOutputView(int numberOfLottoTickets, Lottos lottos) {
        this.numberOfLottoTickets = numberOfLottoTickets;
        this.lottos = lottos;
    }

    public void printLottos(Lottos lottos) {
        printNumberOfLottoTickets();
        printLottoNumbers();
    }

    private void printNumberOfLottoTickets() {
        System.out.println(numberOfLottoTickets + PURCHASE_MESSAGE);
    }

    private void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
