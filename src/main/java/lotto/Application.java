package lotto;

import lotto.calculator.MoneyCalculator;
import lotto.iomanangers.OutputManager;
import lotto.lotto.TicketScratcher;
import lotto.numbergenerator.NumberGenerator;

public class Application {
    public static void main(String[] args) {
        OutputManager outputManager = new OutputManager();
        TicketScratcher ticketScratcher = new TicketScratcher();
        NumberGenerator numberGenerator = new NumberGenerator();
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        LottoSystem lottoSystem = new LottoSystem(moneyCalculator,numberGenerator,ticketScratcher,outputManager);
        lottoSystem.tempRun();
    }
}
