package lotto.core;

import lotto.core.calculator.MoneyCalculator;
import lotto.core.iomanangers.ExceptionOutputManager;
import lotto.core.iomanangers.OutputManager;
import lotto.core.lotto.TicketScratcher;
import lotto.core.numbergenerator.NumberGenerator;

public class LottoStore {
    private final LottoSystem lottoSystem;

    public LottoStore() {
        OutputManager outputManager = new OutputManager();
        TicketScratcher ticketScratcher = new TicketScratcher();
        NumberGenerator numberGenerator = new NumberGenerator();
        MoneyCalculator moneyCalculator = new MoneyCalculator();
        ExceptionOutputManager exceptionOutputManager = new ExceptionOutputManager();
        this.lottoSystem = new LottoSystem(moneyCalculator,numberGenerator,ticketScratcher,outputManager,
                exceptionOutputManager);

    }

    public void start(){
        lottoSystem.process();
    }
}
