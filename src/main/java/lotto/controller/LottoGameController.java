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
        initWinningNumbers(inputView.inputWinningNumbers());
        initBonusNumber(inputView.inputBonusNumber());
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

    public void initWinningNumbers(String input) {
        try {
            winningNumbersBitSet = new Lotto(input).toBitSet();
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initWinningNumbers(inputView.inputWinningNumbers());
        }
    }

    public void initBonusNumber(String input) {
        try {
            bonusNumber = new BonusNumber(input, bonusNumberValidator);
            bonusNumber.validateDuplicatedWithWinning(winningNumbersBitSet);
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            initBonusNumber(inputView.inputBonusNumber());
        }
    }

    void generateLotto() {
        lottos = new Lottos(lottoGenerator.generate(purchase.getLottoCount()));
    }

    void printLottos() {
        outputView.printLottos(lottos);
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

    public BitSet getWinningNumbersBitSet() {
        return winningNumbersBitSet;
    }
}
