package controller;

import domain.LottoMachine;
import java.util.List;
import lotto.Lotto;
import service.LottoGame;
import utils.Utils;
import view.InputView;

public class Controller {
    private LottoGame lottoGame = new LottoGame();

    private void setupLottoMachine() {
        int spend = InputView.inputSpend();
        int lottoTicketCount = spend / 1000;
        List<Integer> lottoNumbers = Utils.generateLottoNumbers();
        List<Lotto> lottoTickets = lottoGame.generateLottoTickets(lottoTicketCount, lottoNumbers);
        new LottoMachine(spend, lottoTickets);
    }
}