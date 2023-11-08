package lotto.controller;

import lotto.model.Percent;
import lotto.view.ConsoleView;
import lotto.model.Lotto;
import lotto.model.LottoTicketMoney;
import lotto.model.Ranking;

import java.util.List;
import java.util.Map;

public class ConsoleOutputService {
    public void printLottos(LottoTicketMoney lottoTicketMoney, List<Lotto> lottos) {
        ConsoleView.printTicketCount(lottoTicketMoney.calculateTicketNumber());
        ConsoleView.printLottoNumbers(lottos);
    }

    public void printRankingStatus(Map<Ranking, Integer> rankingCounts) {
        ConsoleView.printRankingResult(rankingCounts);
    }

    public void printIncomeRate(Percent incomingRate) {
        ConsoleView.printIncomeRate(incomingRate);
    }
}
