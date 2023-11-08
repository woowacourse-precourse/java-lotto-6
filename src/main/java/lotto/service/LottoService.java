package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.utils.MessageConstant;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoService {
    private final InputView inputView;

    public LottoService() {
        this.inputView = new InputView();
    }

    public Money inputMoney() {
        try {
            int money = inputView.inputNumber(MessageConstant.INPUT_PURCHASE_AMOUNT);
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            return inputMoney();
        }
    }

    public Lottos buy(Money money) {
        try {
            int count = money.getLottoCount();
            Lottos lottos = new Lottos(count);
            List<Lotto> lottoList = lottos.getLottos();
            OutputView.printLottos(lottoList);
            return lottos;
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            return buy(money);
        }
    }

    public WinningLotto setWinningLotto() {
        Lotto winningLotto = inputWinningLotto();
        return inputBonusNumber(winningLotto);
    }

    private Lotto inputWinningLotto() {
        try {
            List<Integer> numbers = inputView.inputNumbers(MessageConstant.INPUT_WINNING_NUMBERS);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            return inputWinningLotto();
        }
    }

    private WinningLotto inputBonusNumber(Lotto lotto) {
        try {
            int bonus = inputView.inputNumber(MessageConstant.INPUT_BONUS_NUMBER);
            return new WinningLotto(lotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(MessageConstant.ERROR_PREFIX + e.getMessage());
            return inputBonusNumber(lotto);
        }
    }
}
