package lotto.controller;

import java.util.BitSet;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Purchase;
import lotto.util.LottoGenerator;
import lotto.validator.impl.BonusNumberValidator;
import lotto.validator.impl.LottoValidator;
import lotto.validator.impl.MoneyValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.impl.InputViewImpl;
import lotto.view.impl.OutputViewImpl;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private final BonusNumberValidator bonusNumberValidator;
    private final MoneyValidator moneyValidator;

    private Lottos lottos;
    private BitSet winningNumbersBitSet;
    private BonusNumber bonusNumber;
    private Purchase purchase;

    public LottoGameController() {
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
        this.lottoGenerator = new LottoGenerator();
        this.bonusNumberValidator = new BonusNumberValidator();
        this.moneyValidator = new MoneyValidator();
    }

    public void run() {
        initMoney();
        generateLotto();
        printLottos();
        initWinningNumbers();
        initBonusNumber();
        calculateGameResult();
        printGameResult();
        printProfit();
    }

    void initMoney() {
        try {
            purchase = new Purchase(inputView.inputMoney(), moneyValidator);
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initMoney();
        }
    }

    void generateLotto() {
        lottos = new Lottos(lottoGenerator.generate(purchase.getLottoCount()));
    }

    void printLottos() {
        outputView.printLottos(lottos);
    }

    void initWinningNumbers() {
        try {
            winningNumbersBitSet = new Lotto(inputView.inputWinningNumbers()).toBitSet();
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initWinningNumbers();
        }
    }

    void initBonusNumber() {
        try {
            bonusNumber = new BonusNumber(inputView.inputBonusNumber(), bonusNumberValidator);
            bonusNumber.validateDuplicatedWithWinning(winningNumbersBitSet);
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initBonusNumber();
        }
    }

    void calculateGameResult() {
        lottos.calculateGameResult(winningNumbersBitSet, bonusNumber);
    }

    void printGameResult() {
        outputView.printGameResult(lottos);
    }

    void printProfit() {
        outputView.printProfit(lottos.getProfit(purchase.getMoney()));
    }

}
