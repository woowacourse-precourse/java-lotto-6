package lotto.controller;

import lotto.controller.inputController.LottoBonusWinningNumberController;
import lotto.controller.inputController.LottoWinningNumberController;
import lotto.controller.outputController.LottoPrintController;
import lotto.controller.outputController.LottoReturnsController;
import lotto.controller.outputController.LottoWinningStatisticsController;
import lotto.model.lottoGenerator.LottoNumberGenerator;
import lotto.model.lottoGenerator.LottoPurchase;
import lotto.model.lottoGenerator.LottoTicketCalculator;
import lotto.model.lottoGenerator.LottoTicketCreator;
import lotto.model.lottoResultChecker.*;
import lotto.view.outputView.LottoReturnsOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class LottoController {
    private final LottoPurchase purchase;
    private final LottoTicketCalculator ticketCalculator;
    private final LottoTicketCreator ticketCreator;
    private final LottoWinningNumberController winningNumberController;
    private final LottoBonusWinningNumberController bonusNumberController;
    private final LottoWinningStatistics winningStatistics;
    private final LottoWinningStatisticsController statisticsController;
    private final LottoReturnsCalculator returnsCalculator;
    private final LottoReturnsController returnsController;
    private final LottoTotalWinnings totalWinnings;
    private final List<Lotto> userLottos = new ArrayList<>();
    private int numberOfTicketsSold;
    private static final int TICKET_COST = 1000;

    public LottoController() {
        this.purchase = new LottoPurchase();
        this.ticketCalculator = new LottoTicketCalculator();
        this.ticketCreator = new LottoTicketCreator(new LottoNumberGenerator());
        this.winningNumberController = new LottoWinningNumberController();
        this.bonusNumberController = new LottoBonusWinningNumberController();
        this.winningStatistics = new LottoWinningStatistics();
        this.statisticsController = new LottoWinningStatisticsController();
        this.returnsCalculator = new LottoReturnsCalculator();
        this.returnsController = new LottoReturnsController(new LottoReturnsOutput());
        this.totalWinnings = new LottoTotalWinnings(TICKET_COST);
    }

    public void start() {
        long totalSalesAmount = purchase.getValidatedPurchaseAmount();
        this.numberOfTicketsSold = ticketCalculator.calculateNumberOfTickets((int) totalSalesAmount);
        List<List<Integer>> tickets = ticketCreator.createLottoTickets(numberOfTicketsSold);
        LottoPrintController printController = new LottoPrintController();
        printController.handleLottoDisplay(tickets);
        userLottos.addAll(tickets.stream().map(Lotto::new).toList());
    }

    public void result() {
        Lotto winningLotto = winningNumberController.receiveAndCreateLotto();
        LottoBonus lottoBonus = bonusNumberController.receiveAndCreateLottoBonus(winningLotto.getNumbers());
        Map<LottoRank, Integer> statistics = winningStatistics.calculateStatistics(userLottos, winningLotto, lottoBonus);
        statisticsController.displayStatistics(statistics);
        long totalCost = totalWinnings.calculateTotalSales(numberOfTicketsSold);
        double returnRate = returnsCalculator.calculateReturnRate(statistics, totalCost);
        returnsController.displayReturnRate(returnRate);
    }

}