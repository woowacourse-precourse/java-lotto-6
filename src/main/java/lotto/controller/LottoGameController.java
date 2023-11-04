package lotto.controller;

import lotto.constants.GameMessages;
import lotto.domain.BonusNumber;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.UserNumbers;
import lotto.util.comparer.impl.LottoComparer;
import lotto.util.generator.impl.NumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.impl.InputViewImpl;
import lotto.view.impl.OutputViewImpl;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoComparer lottoComparer;
    private final NumberGenerator numberGenerator;
    private Lotto lotto;
    private UserNumbers userNumbers;
    private BonusNumber bonusNumber;
    private GameResult gameResult;
    private Money money;

    public LottoGameController() {
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
        this.lottoComparer = new LottoComparer();
        this.numberGenerator = new NumberGenerator();
    }

    public void run() {
        initMoney();
    }

    public void initMoney() {
        try {
            money = new Money(inputView.inputMoney());
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initMoney();
        }
    }
}
