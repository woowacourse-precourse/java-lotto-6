package lotto;

import lotto.domain.LottoTickets;
import lotto.ui.InputUI;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputUI inputUI = new InputUI();
        LottoStore lottoStore = new LottoStore(inputUI);
        LottoTickets lottoTickets = lottoStore.buyLotto();
        int size = lottoTickets.size();
        System.out.println("size = " + size);
    }
}
