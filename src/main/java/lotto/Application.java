package lotto;

import lotto.domain.LottoTicket;
import lotto.view.input.AmountInputView;
import lotto.view.input.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView<Integer> amountInputView = new AmountInputView<>(Integer::parseInt);
        int amount = amountInputView.getInput();

        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.createLottoTicket(amount);
    }
}
