package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.Price;
import lotto.Model.RandomLotto;
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

        InputView.inputWinningLotto();

    }

    private Price createPrice() {
        try {
            Price price = new Price(InputView.inputPriceForLotto());
            return price;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createPrice();
        }
    }
}
