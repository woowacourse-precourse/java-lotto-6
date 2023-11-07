package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoProcess {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public LottoResult run(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Integer> counted = new ArrayList<>();
        List<Boolean> checked = new ArrayList<>();

        for (Lotto lotto : lottos) {
            counted.add(winningLotto.getLotto().countOverlappingNumbers(lotto));
            checked.add(lotto.isContainBonusNumber(winningLotto.getBonusNumber()));
        }

        return new LottoResult(counted, checked);
    }

    public List<Lotto> buyLotto(PurchaseMoney purchaseMoney) {
        int lottoQuantity = purchaseMoney.getLottoQuantity();
        List<Lotto> lottos = new ArrayList<>();

        OutputView.printLottoQuantity(lottoQuantity);

        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(NumberGenerator.generate());
            lottos.add(lotto);

            OutputView.printLottoNumbers(lotto.getNumbers());
        }

        return lottos;
    }

    public PurchaseMoney runPurchaseMoneyStep() {
        try {
            return setUpPurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return runPurchaseMoneyStep();
    }

    private PurchaseMoney setUpPurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    public Lotto runWinningNumbersStep() {
        try {
            return setUpWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return runWinningNumbersStep();
    }

    private Lotto setUpWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
    }

    public WinningLotto runWinningLottoStep(Lotto winningNumber) {
        try {
            return setUpWinningLotto(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return runWinningLottoStep(winningNumber);
    }

    private WinningLotto setUpWinningLotto(Lotto winningNumbers) {
        return new WinningLotto(winningNumbers, setUpBonusNumber());
    }

    private int setUpBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}