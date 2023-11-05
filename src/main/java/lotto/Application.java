package lotto;

import lotto.calculator.MoneyCalculator;
import lotto.exception.ExceptionHandler;
import lotto.iomanangers.OutputManager;
import lotto.lotto.TicketScratcher;
import lotto.numbergenerator.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        OutputManager outputManager = new OutputManager();
        TicketScratcher ticketScratcher = new TicketScratcher();
        NumberGenerator numberGenerator = new NumberGenerator();
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        LottoSystem lottoSystem = new LottoSystem(moneyCalculator,numberGenerator,ticketScratcher,outputManager,
                exceptionHandler);
        lottoSystem.run();
    }
}
