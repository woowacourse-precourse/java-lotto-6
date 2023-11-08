package lotto;

import lotto.domain.lotto.Price;
import lotto.io.ConsoleManager;
import lotto.io.View;


public class LottoProgram {
    private final ConsoleManager consoleManager;

    public LottoProgram() {
        this.consoleManager = new ConsoleManager(new View());
    }

    public void buyLotto() {
        Price price = consoleManager.getPrice();
    }
}
