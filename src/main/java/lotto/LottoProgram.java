package lotto;

import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.LottoStatistic;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Price;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.random.LottoNumberCreator;
import lotto.domain.lotto.random.LottoNumberParser;
import lotto.io.ConsoleManager;
import lotto.io.View;


public class LottoProgram {
    private final ConsoleManager consoleManager;
    private final LottoMachine lottoMachine;

    public LottoProgram() {
        this.consoleManager = new ConsoleManager(new View(), new LottoNumberParser());
        this.lottoMachine = new LottoMachine(new LottoNumberCreator());
    }

    public void buyLotto() {
        Price price = consoleManager.getPrice();

        LottoCount count = lottoMachine.getTotalCount(price);
        consoleManager.printLottoCount(count);

        Lottos lottos = lottoMachine.createLottoNumbers(count);
        consoleManager.printLottos(lottos);

        WinningNumber winningNumber = consoleManager.getWinningNumber();

        LottoStatistic lottoStatistic = lottoMachine.getLottoStatistic(lottos, winningNumber);
        consoleManager.printLottoStatistic(lottoStatistic);

    }
}
