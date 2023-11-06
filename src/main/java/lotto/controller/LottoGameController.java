package lotto.controller;

import java.util.BitSet;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.util.generator.impl.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.impl.InputViewImpl;
import lotto.view.impl.OutputViewImpl;

public class LottoGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;
    private Lottos lottos;
    private Lotto winningNumbers;
    private BitSet winningNumbersBitSet;
    private BonusNumber bonusNumber;
    private Money money;

    public LottoGameController() {
        this.inputView = new InputViewImpl();
        this.outputView = new OutputViewImpl();
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        initMoney();
        generateLotto();
        inputWinningNumbers();
        initBonusNumber();
        calculateGameResult();
        printGameResult();
        printProfit();
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
            winningNumbersBitSet = winningNumbers.toBitSet();
        }
        catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            inputWinningNumbers();
        }
    }

    void initBonusNumber() {
        try {
            bonusNumber = new BonusNumber(inputView.inputBonusNumber(), winningNumbersBitSet);
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
        outputView.printProfit(getProfit());
    }

    double getProfit() {
        double prizeMoney = lottos.getPrizeMoney();
        long money = this.money.getMoney();
        return prizeMoney / money * 100;
    }

}
