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
        String purchaseAmountAskMessage = messageManager.purchaseAmountAskMessage();
        ConsoleOutputManager.printOut(purchaseAmountAskMessage);
    }

    public Integer chooseAmount(String input) {
        return numberGenerator.createAmountToQuantity(input);
    }

    public List<LottoTicket> saveLottoTickets(Integer amountToQuantity) {
        String printQuantityAnnounce = messageManager.QuantityAnnounceMessage(amountToQuantity);
        ConsoleOutputManager.printOut(printQuantityAnnounce);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountToQuantity; i++) {
            List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
            LottoTicket lottoTicket = new LottoTicket(randomUniqueNumber);

            String oneLottoTicketMessage = messageManager.OneLottoTicketMessage(lottoTicket);
            ConsoleOutputManager.printOut(oneLottoTicketMessage);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public void printWinningNumberAsk() {
        String winningNumberAskMessage = messageManager.winningNumberAskMessage();
        ConsoleOutputManager.printOut(winningNumberAskMessage);
    }

    public WinningNumbers chooseWinningNumber(String input) {
        return numberGenerator.createWinningNumbersFromConsole(input);
    }

    public void printBonusNumberAsk() {
        String bonusNumberAskMessage = messageManager.bonusNumberAskMessage();
        ConsoleOutputManager.printOut(bonusNumberAskMessage);
    }

    public BonusNumber chooseBonusNumber(String input) {
        Integer bonusNumberFormConsole = numberGenerator.createBonusNumberFromConsole(input);
        return new BonusNumber(bonusNumberFormConsole);
    }

    public String printWinningChart(Integer amountToQuantity, ScratchedLottoTicketList scratchedLottoTicketList) {
        String winningChartAnnounceMessage = messageManager.winningChartAnnounceMessage();
        ConsoleOutputManager.printOut(winningChartAnnounceMessage);

        calculator.calculate(scratchedLottoTicketList, amountToQuantity);
        BigDecimal rateOfReturn = calculator.getRateOfReturn();
        String winningChartAndRateOfReturnMessage = messageManager.winningChartAndRateOfReturnMessage(
                scratchedLottoTicketList,
                rateOfReturn);
        ConsoleOutputManager.printOut(winningChartAndRateOfReturnMessage);
        return winningChartAndRateOfReturnMessage;
    }
}
