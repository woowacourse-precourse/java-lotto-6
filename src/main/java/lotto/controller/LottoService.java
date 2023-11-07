package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumberGenerator;
import lotto.model.LottoTicketMoney;
import lotto.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final List<Lotto> lottos = new ArrayList<>();
    private LottoTicketMoney lottoTicketMoney;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;

    public void issueLottoTicket() {
        lottoTicketMoney = UserInput.inputPrice();
        for (int i = 0; i < lottoTicketMoney.calculateTicketNumber(); i++) {
            lottos.add(
                    new Lotto(LottoNumberGenerator.createNumbers())
            );
        }
    }

    public void printLottos() {
        ConsoleView.printTicketCount(lottoTicketMoney.calculateTicketNumber());
        ConsoleView.printLottoNumbers(lottos);
    }

    public void inputWinningNumbers() {
        winningNumbers = UserInput.inputWinningLotto();
    }

    public void inputBonusNumber() { bonusNumber = UserInput.inputBonusNumber(); }
}
