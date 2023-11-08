package lotto;

import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.Price;
import lotto.io.ConsoleManager;
import lotto.io.View;


public class LottoProgram {
    private final ConsoleManager consoleManager;
    private final LottoMachine lottoMachine;

    public LottoProgram() {
        this.consoleManager = new ConsoleManager(new View());
        this.lottoMachine = new LottoMachine();
    }

    public void buyLotto() {
        Price price = consoleManager.getPrice();
        LottoCount count = lottoMachine.getTotalCount(price);
        consoleManager.printLottoCount(count);
    }
}
