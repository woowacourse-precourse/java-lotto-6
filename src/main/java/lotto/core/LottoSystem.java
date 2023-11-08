package lotto.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.core.calculator.Calculator;
import lotto.core.iomanangers.ConsoleOutputManager;
import lotto.core.iomanangers.MessageManager;
import lotto.core.lotto.BonusNumber;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.lotto.ScratchedLottoTicketList;
import lotto.core.lotto.WinningNumbers;
import lotto.core.numbergenerator.NumberGenerator;

public class LottoSystem {
    private final Calculator calculator;
    private final NumberGenerator numberGenerator;
    private final LottoTicketScratcher lottoTicketScratcher;
    private final MessageManager messageManager;

    public LottoSystem(Calculator calculator, LottoTicketScratcher lottoTicketScratcher,
                       NumberGenerator numberGenerator, MessageManager messageManager) {
        this.calculator = calculator;
        this.numberGenerator = numberGenerator;
        this.lottoTicketScratcher = lottoTicketScratcher;
        this.messageManager = messageManager;
    }

    public ScratchedLottoTicketList calculateWinningChart(List<LottoTicket> lottoTickets,
                                                          WinningNumbers winningNumbers,
                                                          BonusNumber bonusNumber) {
        return lottoTicketScratcher.scratchAllTickets(winningNumbers, bonusNumber, lottoTickets);
    }

    public void printPurchaseAmountAsk() {
        messageManager.printPurchaseAmountAsk();
    }

    public Integer chooseAmount(String input) {
        return numberGenerator.createAmountToQuantity(input);
    }

    public List<LottoTicket> saveLottoTickets(Integer amountToQuantity) {
        messageManager.printQuantityAnnounce(amountToQuantity);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountToQuantity; i++) {
            List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
            LottoTicket lottoTicket = new LottoTicket(randomUniqueNumber);
            messageManager.printOneLottoTicketAnnounce(lottoTicket);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public void printWinningNumberAsk() {
        messageManager.printWinningNumberAsk();
    }

    public WinningNumbers chooseWinningNumber(String input) {
        return numberGenerator.createWinningNumbersFromConsole(input);
    }

    public void printBonusNumberAsk() {
        messageManager.printBonusNumberAsk();
    }

    public BonusNumber chooseBonusNumber(String input) {
        Integer bonusNumberFormConsole = numberGenerator.createBonusNumberFromConsole(input);
        return new BonusNumber(bonusNumberFormConsole);
    }

    public String printWinningChart(Integer amountToQuantity, ScratchedLottoTicketList scratchedLottoTicketList) {

        messageManager.printWinningChartAnnounce();
        String chartContent = messageManager.printWinningChart(scratchedLottoTicketList);

        calculator.calculate(scratchedLottoTicketList, amountToQuantity);
        BigDecimal rateOfReturn = calculator.getRateOfReturn();
        String rateOfReturnContent = messageManager.printOut(rateOfReturn);

        String winningChart = chartContent + System.lineSeparator() + rateOfReturnContent;
        ConsoleOutputManager.printOut(winningChart);
        return winningChart;
    }


}
