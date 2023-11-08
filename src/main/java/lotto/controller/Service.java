package lotto.controller;

import lotto.model.*;

import java.util.List;
import java.util.Map;

public class Service {
    private final LottoTicketService lottoTicketService;
    private final WinningNumberService winningNumberService;
    private final RankingService rankingService;
    private final ResultCalculationService resultCalculationService;
    private final ConsoleOutputService consoleOutputService;
    private LottoTicketMoney lottoTicketMoney;
    private List<Lotto> lottos;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private List<Ranking> rankingResults;
    private Map<Ranking, Integer> rankingCounts;
    private Percent incomingRate;

    public Service() {
        lottoTicketService = new LottoTicketService();
        winningNumberService = new WinningNumberService();
        rankingService = new RankingService();
        resultCalculationService = new ResultCalculationService();
        consoleOutputService = new ConsoleOutputService();
    }

    public void start() {
        buyLottos();
        inputWinningConditions();
        checkRanking();
        calculatePrice();
        showResult();
    }

    private void buyLottos() {
        lottoTicketMoney = lottoTicketService.issueLottoTicket();
        lottos = lottoTicketService.getLottos();
        consoleOutputService.printLottos(lottoTicketMoney, lottos);
    }

    private void inputWinningConditions() {
        winningNumbers = winningNumberService.inputWinningNumbers();
        bonusNumber = winningNumberService.inputBonusNumber(winningNumbers);
    }

    private void checkRanking() {
        rankingResults = rankingService.calculateRankingResults(lottos, winningNumbers, bonusNumber);
        rankingCounts = rankingService.countRanking(rankingResults);
    }

    private void calculatePrice() {
        resultCalculationService.calculatePrice(rankingCounts);
        incomingRate = resultCalculationService.calculateIncomeRate(lottoTicketMoney);
    }

    private void showResult() {
        consoleOutputService.printRankingStatus(rankingCounts);
        consoleOutputService.printIncomeRate(incomingRate);
    }
}
