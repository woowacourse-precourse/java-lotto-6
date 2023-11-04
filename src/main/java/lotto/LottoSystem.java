package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.calculator.MoneyCalculator;
import lotto.lotto.TicketScratcher;
import lotto.numbergenerator.NumberGenerator;

public class LottoSystem {
    private final MoneyCalculator moneyCalculator;
    private final NumberGenerator numberGenerator;
    private final TicketScratcher ticketScratcher;

    public LottoSystem(MoneyCalculator moneyCalculator,
                       NumberGenerator numberGenerator,
                       TicketScratcher ticketScratcher) {
        this.moneyCalculator = moneyCalculator;
        this.numberGenerator = numberGenerator;
        this.ticketScratcher = ticketScratcher;
    }

    public void tempRun(){

    }

    private void readLine(){
        Console.readLine();
    }

    private void close(){
        Console.close();
    }
}
