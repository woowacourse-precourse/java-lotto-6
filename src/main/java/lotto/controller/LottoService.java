package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoTicketMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<Lotto> lottos = new ArrayList<>();
    private LottoTicketMoney lottoTicketMoney;
    private Lotto winningNumbers;

    private static final String TICKET_NUMBER_STATEMENT = "개를 구매했습니다.";

    public void issueLottoTicket() {
        lottoTicketMoney = UserInput.inputPrice();
        for (int i = 0; i < lottoTicketMoney.calculateTicketNumber(); i++) {
            lottos.add(new Lotto(LottoNumberGenerator.createNumbers()));
        }
    }

    public void printLottos() {
        System.out.printf(("%d" + TICKET_NUMBER_STATEMENT),
                lottoTicketMoney.calculateTicketNumber());
        for (Lotto lotto: lottos) {
            System.out.println(lotto);
        }
    }

    public void inputWinningNumbers() {
        winningNumbers = UserInput.inputWinningLotto();
    }
}
