package lotto.controller;

import lotto.model.*;
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

    public void inputBonusNumber() { bonusNumber = UserInput.inputBonusNumber(winningNumbers); }

    public List<Ranking> calculateRankingResults() {
        List<Ranking> ticketRankings = new ArrayList<>();
        for (Lotto lotto: lottos) {
            ticketRankings.add(lotto.checkRanking(winningNumbers, bonusNumber));
        }
        return ticketRankings;
    }
}
