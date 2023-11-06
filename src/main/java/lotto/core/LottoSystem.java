package lotto.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.core.calculator.Calculator;
import lotto.core.iomanangers.OutputManager;
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
    private final OutputManager outputManager;

    public LottoSystem(Calculator calculator, LottoTicketScratcher lottoTicketScratcher,
                       NumberGenerator numberGenerator, OutputManager outputManager) {
        this.calculator = calculator;
        this.numberGenerator = numberGenerator;
        this.lottoTicketScratcher = lottoTicketScratcher;
        this.outputManager = outputManager;
    }

    public ScratchedLottoTicketList calculateWinningChart(List<LottoTicket> lottoTickets,
                                                          WinningNumbers winningNumbers,
                                                          BonusNumber bonusNumber) {
        return lottoTicketScratcher.scratchAllTickets(winningNumbers, bonusNumber, lottoTickets);
    }

    public void printPurchaseAmountAsk() {
        outputManager.printPurchaseAmountAsk();
    }

    public Integer chooseAmount(String input) {
        return numberGenerator.createAmountToQuantity(input);
    }

    public List<LottoTicket> saveLottoTickets(Integer amountToQuantity) {
        outputManager.printQuantityAnnounce(amountToQuantity);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountToQuantity; i++) {
            List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
            LottoTicket lottoTicket = new LottoTicket(randomUniqueNumber);
            outputManager.printOneLottoTicketAnnounce(lottoTicket);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public void printWinningNumberAsk() {
        outputManager.printWinningNumberAsk();
    }

    public WinningNumbers chooseWinningNumber(String input) {
        return numberGenerator.createWinningNumbersFromConsole(input);
    }

    public void printBonusNumberAsk() {
        outputManager.printBonusNumberAsk();
    }

    public BonusNumber chooseBonusNumber(String input) {
        Integer bonusNumberFormConsole = numberGenerator.createBonusNumberFromConsole(input);
        return new BonusNumber(bonusNumberFormConsole);
    }

    public String printWinningChart(Integer amountToQuantity, ScratchedLottoTicketList scratchedLottoTicketList) {

        outputManager.printWinningChartAnnounce();
        String chartContent = outputManager.printWinningChart(scratchedLottoTicketList);

        calculator.calculate(scratchedLottoTicketList, amountToQuantity);
        BigDecimal rateOfReturn = calculator.getRateOfReturn();
        String rateOfReturnContent = outputManager.makeRateOfReturnForm(rateOfReturn);

        String winningChart = chartContent + System.lineSeparator() + rateOfReturnContent;
        outputManager.makeRateOfReturnForm(winningChart);
        return winningChart;
    }





}
