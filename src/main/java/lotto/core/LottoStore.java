package lotto.core;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Function;
import lotto.core.calculator.Calculator;
import lotto.core.exception.LottoApplicationException;
import lotto.core.iomanangers.ExceptionOutputManager;
import lotto.core.iomanangers.OutputManager;
import lotto.core.lotto.BonusNumber;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.ScratchedLottoTicketList;
import lotto.core.lotto.LottoTicketScratcher;
import lotto.core.lotto.WinningNumbers;
import lotto.core.numbergenerator.NumberGenerator;

public class LottoStore {
    private final LottoSystem lottoSystem;

    public LottoStore(LottoSystem lottoSystem) {
        this.lottoSystem = lottoSystem;
    }

    public static LottoStore createStore (){
        OutputManager outputManager = new OutputManager();
        LottoTicketScratcher lottoTicketScratcher = new LottoTicketScratcher();
        NumberGenerator numberGenerator = new NumberGenerator();
        Calculator calculator = new Calculator();
        LottoSystem lottoSystem = new LottoSystem(calculator,lottoTicketScratcher,numberGenerator, outputManager);
        return new LottoStore(lottoSystem);
    }


    public static LottoStore createStoreForTest(LottoTicketScratcher lottoTicketScratcher,Calculator calculator,NumberGenerator numberGenerator,OutputManager outputManager) {
        LottoSystem customLottoSystem = new LottoSystem(calculator, lottoTicketScratcher, numberGenerator, outputManager);
        return new LottoStore(customLottoSystem);
    }

    public void start(){
        this.process();
    }

    private void process() {
        try {
            lottoSystem.printPurchaseAmountAsk();
            Integer amountToQuantity = this.getInputAndCatchException(lottoSystem::chooseAmount);
            List<LottoTicket> lottoTickets = lottoSystem.saveLottoTickets(amountToQuantity);

            lottoSystem.printWinningNumberAsk();
            WinningNumbers winningNumbers = this.getInputAndCatchException(lottoSystem::chooseWinningNumber);

            lottoSystem.printBonusNumberAsk();
            BonusNumber bonusNumber = this.getInputAndCatchException(lottoSystem::chooseBonusNumber);
            ScratchedLottoTicketList scratchedLottoTicketList = lottoSystem.calculateWinningChart(lottoTickets,
                    winningNumbers, bonusNumber);

            lottoSystem.printWinningChart(amountToQuantity, scratchedLottoTicketList);
        } finally {
            this.close();
        }
    }

    private String readLine(){
        return Console.readLine();
    }

    private void close(){
        Console.close();
    }

    private <T> T getInputAndCatchException(Function<String, T> processor) {
        while (true) {
            try {
                String input = this.readLine();
                return processor.apply(input);
            } catch (LottoApplicationException e) {
                ExceptionOutputManager.printException(e);
            }
        }
    }
}
