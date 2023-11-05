package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.comparer.impl.LottoComparer;
import lotto.util.generator.impl.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.impl.InputViewImpl;
import lotto.view.impl.OutputViewImpl;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoComparer lottoComparer;
    private final LottoGenerator lottoGenerator;
    private Lottos lottos;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private GameResult gameResult;
    private Money money;

    public LottoGameController() {
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
        this.lottoComparer = new LottoComparer();
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        initMoney();
        generateLotto();
        inputWinningNumbers();
    }

    void initMoney() {
        try {
            money = new Money(inputView.inputMoney());
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initMoney();
        }
    }

    void generateLotto() {
        lottos = new Lottos(lottoGenerator.generate(money.getLottoCount()));
        printLottos();
    }

    void printLottos() {
        outputView.printLottos(lottos);
    }

    void inputWinningNumbers() {
        try {
            winningNumbers = new Lotto(inputView.inputWinningNumbers());
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            inputWinningNumbers();
        }
    }
}
