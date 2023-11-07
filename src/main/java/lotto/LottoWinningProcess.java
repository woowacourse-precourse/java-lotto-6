package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoWinningProcess {
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

    public PurchaseMoney setUpPurchaseMoney() {
        String purchaseMoney = InputView.inputPurchaseMoney();
        return new PurchaseMoney(Converter.convertToNumeric(purchaseMoney));
    }

    public PurchaseMoney one() {
        try {
            return setUpPurchaseMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return one();
    }

    public WinningLotto setUpWinningLotto(Lotto winningNumbers) {
        //return new WinningLotto(setUpWinningNumbers(), setUpBonusNumber());
        return new WinningLotto(winningNumbers, setUpBonusNumber());
    }

    public WinningLotto three(Lotto winningNumber) {
        try {
            return setUpWinningLotto(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return three(winningNumber);
    }

    public Lotto setUpWinningNumbers() {
        String winningNumbers = InputView.inputWinningNumbers();
        return new Lotto(Converter.convertWinningNumber(winningNumbers));
    }

    public Lotto two() {
        try {
            return setUpWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
        }
        return two();
    }

    public int setUpBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        return Converter.convertToNumeric(bonusNumber);
    }
}