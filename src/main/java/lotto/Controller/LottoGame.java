package lotto.Controller;

import lotto.Model.Bonus;
import lotto.Model.Lotto;
import lotto.Model.Price;
import lotto.Model.RandomLotto;
import lotto.Model.Result;
import lotto.Model.WinningLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGame {

    public void start() {
        Price price = createPrice();

        RandomLotto randomLotto = new RandomLotto(price);

        OutputView.printLottoPurChaseMessage(randomLotto);
        while (randomLotto.minusCount() > 0) {
            Lotto lotto = randomLotto.createRandomLottos();
            OutputView.printRandomLottoNumbers(lotto);
        }
        // ------로또 구입 금액 받아서 랜덤로또번호 출력까지

        WinningLotto winningLotto = createWinningLotto();

        Bonus bonus = createBonusNumber(winningLotto);


    }

    private Price createPrice() {
        try {
            return new Price(InputView.inputPriceForLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return createPrice();
        }
    }

    private WinningLotto createWinningLotto() {
        try {
            return new WinningLotto(InputView.inputWinningLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createWinningLotto();
        }
    }

    private Bonus createBonusNumber(WinningLotto winningLotto) {
        try {
            Bonus bonus = new Bonus(InputView.inputBonusNumber());
            winningLotto.compare(bonus);
            return bonus;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createBonusNumber(winningLotto);
        }
    }
}
